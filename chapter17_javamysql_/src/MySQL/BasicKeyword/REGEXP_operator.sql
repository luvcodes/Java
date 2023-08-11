-- regular expression
-- ^ beginning
-- $ end
-- | logical or
-- [abcd]
-- [a-f]
select *
from sql_store.customers
-- where last_name like '%field%';
-- 下面这句和上面的是一样的
-- where last_name REGEXP 'field';

-- 意思是在lastname中查找开始的5个字符是field
-- where last_name REGEXP '^field';

-- 意思是在lastname中查找结束的最后5个字符是field
-- where last_name REGEXP 'field$';

-- 想要搜索多种情况的characters， lastname中包含field 或者 mac 或者 rose
-- where last_name REGEXP 'field|mac|rose';

-- 也可以与上面使用到的^, $结合使用
-- where last_name REGEXP 'field$|mac|rose';

-- 这样可以查到ge，ie，me
-- where last_name regexp '[gim]e';

-- ef, em, eq
-- where last_name regexp 'e[fmq]';

-- a to h, all combinations with e
-- where last_name regexp '[a-h]e';

-- excercise1
-- where first_name regexp 'ELKA|AMBUR';

-- excercise2
-- where last_name regexp 'EY$|ON$';

-- excercise3
-- where last_name regexp '^MY|SE';

-- excercise4
where last_name regexp 'B[RU]';