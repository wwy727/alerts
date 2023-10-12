I used data.txt file as the data storage system to read and wirte alert data, the file is empty initially, and below are the results of the API I tested.

Write alerts

1. Write requests and reponses
![img_1.png](img_1.png)

![img_3.png](img_3.png)

data been added to the data.txt
![img_4.png](img_4.png)

2. Error

if I write the data with same alert_id, error will happen
![img_5.png](img_5.png)


Read Alerts

1. Read requests and reponse
![img_6.png](img_6.png)
![img_7.png](img_7.png)

2. Error

3. if I read the data without a service_id, error will happen
![img_8.png](img_8.png)


