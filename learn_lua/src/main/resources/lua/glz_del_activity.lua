--
-- ARGV[1] 头key
-- ARGV[2] activitySkuLineKey
-- ARGV[3] activitySpuLineKey
-- ARGV[4] 启用中的头key
-- ARGV[5] 活动CODE
-- ARGV[6] spu排序key
--
local activityHeaderKey = ARGV[1];
local activitySkuLineKey = ARGV[2];
local activitySpuLineKey = ARGV[3];
local activityActiveKey = ARGV[4];
local activityCode = ARGV[5];
local activitySpuLineSortKey = ARGV[6];

-- 删除头
redis.call('del', activityHeaderKey);

-- 删除行
local activitySkuLine = redis.call('smembers', activitySkuLineKey);
for index, value in pairs(activitySkuLine) do
    local activityLineKey = 'o2mkt:glz_activity:entry:' .. activityCode .. ':' .. value;
    redis.call('del', activityLineKey);
end
redis.call('del', activitySkuLineKey);

-- 删除SPU行维度数据
redis.call('del', activitySpuLineKey);
-- 删除启用中的头数据
redis.call('srem', activityActiveKey, activityCode);
-- 删除SPU排序数据
redis.call('del', activitySpuLineSortKey);