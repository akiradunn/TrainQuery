# TrainQuery
提供查询余票与硬卧,硬座,无座车价;
~谁叫本汪是穷学生呢,哈哈

Main.java提供了查询的入口;

1.查询余票情况,结果在lefttickets.txt:
通过在其中指定几个参数:
出发站:start_station_name
终点站:end_station_name
查询日期:date
可以查询余票情况;

2.查询价钱,结果在price.txt:
想要在余票中指定车次进行查询单价,需要指定车次:station_train_code,车次号可以从余票查询结果中获取.



这个查询小工具很简单,还有很多不足,还没能将查询结果放入数据库,或者是用网页动态生成结果
