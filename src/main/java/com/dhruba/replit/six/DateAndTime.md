Limitations of old date and time:
---------------------------------
1)the old date was an instant i.e. both date + time. so not possible to get date withour team
2)months were numbered 0 to 11
3)Timezone was represented by String. TimeZone zone = TimeZone.getInstance(“Asia/Hong_Kong”); This is very error prone

The new date and time api has been moved to java.time package and the Joda time format is followed.