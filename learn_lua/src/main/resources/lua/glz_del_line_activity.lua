--
-- ARGV[1] 行key
-- ARGV[2] platformSkuCodeList
-- ARGV[3] activitySpuLineKey
-- ARGV[4] spu2SkuMap
-- ARGV[5] 活动CODE
-- ARGV[6] spu排序key
--
local activitySkuLineKey = ARGV[1];
local deleteLine =  cjson.decode(ARGV[2]);
local activitySpuLineKey = ARGV[3];
local deleteSpuLine = cjson.decode(ARGV[4]);
local activityCode = ARGV[5];
local activitySpuLineSortKey = ARGV[6];

-- 删除活动行
for key, value in pairs(deleteLine) do
    redis.call("srem", activitySkuLineKey, value);
    local activityLineKey = 'o2mkt:glz_activity:entry:' .. activityCode .. ':' .. value;
    redis.call('del', activityLineKey);
end

-- 删除SPU行维度数据
for key, value in pairs(deleteSpuLine) do
    if cjson.encode(value) and '{}' ~= cjson.encode(value) then
        redis.call('hset', activitySpuLineKey, key, cjson.encode(value));
    else
        redis.call("hdel", activitySpuLineKey, key);
        redis.call('zrem', activitySpuLineSortKey, key);
    end
end