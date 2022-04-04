## 方法一

offset 必须写在 limit 后面，不然会报语法错误。

注意，solu1 中不能直接这样写：

```sql
select distinct salary
from Employee
order by salary desc
limit 1 offset 1
```

因为如果这样写，那么，在匹配不到数据的情况下，查询的结果是返回 NULL 但是结果不显示，而 `select NULL` 会返回 NULL 并且显示。

## 方法二

使用 ifnull 和 limit 语句。

```sql
select (
    ifnull(
        (select distinct salary
        from Employee
        order by salary desc
        limit 1 offset 1), null
    )
) as SecondHighestSalary;
```

`IFNULL(expr1,expr2)` 的用法：

假如 expr1 不为 NULL，则 IFNULL() 的返回值为 expr1；否则其返回值为 expr2。