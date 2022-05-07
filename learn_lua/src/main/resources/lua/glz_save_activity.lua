--
-- ARGV[1] 头key                String.format("o2mkt:glz_activity:detail:%s", activityCode)
-- ARGV[2] 头value              JsonHelper.objectToString(glzActivity)
-- ARGV[3] 行value              JsonHelper.objectToString(activityLineMap)
-- ARGV[4] sku行key             String.format("o2mkt:glz_activity:sku_entry:%s", activityCode);
-- ARGV[5] spu行key             String.format("o2mkt:glz_activity:spu_entry:%s", activityCode);
-- ARGV[6] spu-sku map          JsonHelper.mapToString(spuOfSkuMap)
-- ARGV[7] spu排序key            String.format("o2mkt:glz_activity:spu_entry:sort:%s", activityCode);
-- ARGV[8] spu排序数据            JsonHelper.mapToString(spuSortMap)

--[[
String activityHeaderKey = String.format("o2mkt:glz_activity:detail:%s", activityCode);
String activitySkuLineKey = String.format("o2mkt:glz_activity:sku_entry:%s", activityCode);
String activitySpuLineKey = String.format("o2mkt:glz_activity:spu_entry:%s", activityCode);
String activitySpuLineSortKey = String.format("o2mkt:glz_activity:spu_entry:sort:%s", activityCode);
Map<String, List<String>> spuOfSkuMap = platformProductCode : platformSkuCodeList;
Map<String, Integer> spuSortMap = platformProductCode : hash;
List<Map<String, Object>> activityLineMap = 其中的map为活动行表的 属性名：属性值

总共有四个键，活动头键，活动行sku键，spu键，spu排序键

]]--

--
local activityHeaderKey = ARGV[1];                  -- String.format("o2mkt:glz_activity:detail:%s", activityCode)
local activityHeaderJSON = ARGV[2];                 --JsonHelper.objectToString(glzActivity)
local activityLineList = cjson.decode(ARGV[3]);     --JsonHelper.objectToString(activityLineMap)
local activitySkuLineKey = ARGV[4];                 --String.format("o2mkt:glz_activity:sku_entry:%s", activityCode);
local activitySpuLineKey = ARGV[5];                 --String.format("o2mkt:glz_activity:spu_entry:%s", activityCode);
local spuOfSkuMap = cjson.decode(ARGV[6]);          --JsonHelper.mapToString(spuOfSkuMap)
local activitySpuLineSortKey = ARGV[7];             --String.format("o2mkt:glz_activity:spu_entry:sort:%s", activityCode);
local spuSortMap = cjson.decode(ARGV[8]);           --JsonHelper.mapToString(spuSortMap)

-- 保存头
redis.call('set', activityHeaderKey, activityHeaderJSON);
-- String.format("o2mkt:glz_activity:detail:%s", activityCode) : JsonHelper.objectToString(glzActivity)

-- 保存行 获取activityCode
local activityCode = cjson.decode(activityHeaderJSON)['activityCode'];

-- 使用数量 每一个行信息
for index, activityLineMap in pairs(activityLineList) do
    local platformSkuCode = activityLineMap['platformSkuCode'];
    -- String.format("o2mkt:glz_activity:sku_entry:%s", activityCode) : -> platformSkuCode
    redis.call('sadd', activitySkuLineKey, platformSkuCode);
    -- 活动行hash
    local recvCount = 0;
    -- o2mkt:glz_activity:entry:activityCode:platformSkuCode
    -- 根据这个哈希键获取recvCount，获取不到就为0，获取到就赋值recvCount
    local activityLineKey = 'o2mkt:glz_activity:entry:' .. activityCode .. ':' .. platformSkuCode;
    if redis.call('exists', activityLineKey) == 1 then
        local tempRecvCount = redis.call('hget', activityLineKey, 'recvCount');
        recvCount = tempRecvCount == nil and recvCount or tempRecvCount;
        redis.call('del', activityLineKey)
    end
    redis.call('hset', activityLineKey, "recvCount", recvCount);

    -- 对每个行信息的键值对
    for fieldKey, fieldValue in pairs(activityLineMap) do
        redis.call('hset', activityLineKey, fieldKey, fieldValue);
    end
end

-- 保存SPU行维度数据  hash String.format("o2mkt:glz_activity:spu_entry:%s", activityCode) :  platformProductCode : platformSkuCodeList;
for fieldKey, fieldValue in pairs(spuOfSkuMap) do
    redis.call('hset', activitySpuLineKey, fieldKey, cjson.encode(fieldValue));
end

-- 保存SPU排序数据 hash String.format("o2mkt:glz_activity:spu_entry:sort:%s", activityCode)  hash : platformProductCode
for fieldKey, fieldValue in pairs(spuSortMap) do
    redis.call('zadd', activitySpuLineSortKey, tonumber(fieldValue), fieldKey);
end