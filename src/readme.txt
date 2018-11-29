license.txt
* ExactData license information

logon.csv
* Fields: id, date, user, pc, activity (Logon/Logoff)
* Logoff requires preceding logon
* Some logons occur after-hours
  - After-hours logins and after-hours thumb drive usage are intended to be significant.
* Logons precede other PC activity
* Screen unlocks are recorded as logons. Screen locks are not recorded.
* Any particular user’s average habits persist day-to-day
  - Start time (+ a small amount of variance)
  - Length of work day (+ a small amount of variance)
  - After-hours work: some users will logon after-hours, most will not
* 5 day work weeks: daily user logons only occur on work days.   (a user could have an after-hours logon on a Friday evening and not logoff until Saturday morning)
* Some employees leave the organization:  no new logon activity from the default start time on the day of termination
* 1k users, each with an assigned PC
* 100 shared machines used by some of the users in addition to their assigned PC. These are shared in the sense of a computer lab, not in the sense of a Unix server or Windows Terminal Server.
* 12 systems administrators with global access privileges (12 of the 1,000 users:  job role = IT Admin)

device.csv
* Fields: id, date, user, pc, activity (connect/disconnect)
* Some users use a thumb drive
* Some connect events may be missing disconnect events, because users can power down machine before removing drive
* Users are either thumb drive users or not. This is binary. The frequency with which a user uses a thumb drive is not intended to be significant.

LDAP and Administrative records
* 18 LDAP.csv files
  - Fields: employee_name, user_id, email, domain, role
  - Each LDAP file lists active employees at the end of the month (month covered is part of the LDAP file name).  A user that departs / is terminated in the middle of the month will be listed in the previous month, but not in the month that he/she is terminated.

HTTP.csv
* Fields: id, date, user, pc, url
* Up to 15 URLs visited daily between daily logon and daily logoff
* Up to 5 URLs visited daily after-hours
* Generated using RTG (www.cs.cmu.edu/~christos/PUBLICATIONS/pkdd09_rtg.pdf) with some post-processing steps.
* WARNING: Most of the domain names are randomly generated, so some may point to malicious websites. Please exercise caution if visiting any of them.


Errata:
* Field Ids are unique within a csv file (logon.csv, device.csv) but may not be globally unique.

Some known deficiencies:
We’ve worked to make the data realistic in certain, very specific ways, listed above. But it is unrealistic in most dimensions. Here is a list of just some of the ways this data does not match what you would expect in real data.
* Users either tend to use thumb drives or they don’t. But for thumb drive users, there is no significance or trend regarding their frequency of usage.
* User behavior is not influenced by the day of the week.
* Users never log in on weekends, and there is no awareness of holidays.
