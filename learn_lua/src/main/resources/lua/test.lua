
-- id -> num
-- num -> name

--local idKey = KEYS[1];
--local numKey = KEYS[2];
--
--local idValue = ARGV[1];
--local numValue = ARGV[2];

local s1 = ARGV[1];
local s2 = ARGV[2];
local s3 = ARGV[3];
local s4 = ARGV[4];



--redis.call('set',idKey,idValue);
--
--redis.call('set',numKey,numValue);

redis.call('set',cjson.decode(s1)['id'],s1);
redis.call('set',cjson.decode(s2)['id'],s2);
redis.call('set',cjson.decode(s3)['id'],s3);
redis.call('set',cjson.decode(s4)['id'],s4);