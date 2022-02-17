
-- id -> num
-- num -> name

--local idKey = KEYS[1];
--local numKey = KEYS[2];
--
--local idValue = ARGV[1];
--local numValue = ARGV[2];

local s1 = ARGV[1];
local s2 = cjson.decode(ARGV[1]);


--redis.call('set',idKey,idValue);
--
--redis.call('set',numKey,numValue);

local temKey = "student:".."list"
local josnKey = "josnKey:".."josn"

redis.call('hset',temKey,"list",s1)


for i, map in ipairs(s2) do
    for key, value in pairs(map) do
        local tem = i..key
        redis.call('hset',josnKey,tem,value);
    end
end