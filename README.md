# quantcast_swe_22
Here is a description of the test suite used.

Test 1: No csv file is inputted. 
```
./most_active_cookie -d 2018-12-09
```
Expected Output:
```
No date or log inputted.
```

Test 2: No date is inputted.
```
./most_active_cookie cookie_log.csv
```
Expected Output:
```
No date or log inputted.
```

Test 3: Neither a csv file nor date is inputted.
```
./most_active_cookie
```
Expected Output:
```
No date or log inputted.
```

Test 4: No cookies logged.
```
./most_active_cookie cookie_log_two.csv -d 2020-12-09
```
Expected Output:
```
No date or log inputted.
```

Test 5: One most common cookie.
```
./most_active_cookie cookie_log.csv -d 2018-12-09
```
Expected Output:
```
AtY0laUfhglK3lC7
```

Test 6: Multiple most common cookies.
```
./most_active_cookie cookie_log.csv -d 2018-12-08
```
Expected Output:
```
fbcn5UAVanZf6UtG
SAZuXPGUrfbcn5UA
4sMM2LxV07bPJzwf
```
