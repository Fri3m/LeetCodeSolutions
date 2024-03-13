def maximumTime(time):
    """
    :type time: str
    :rtype: str
    """
    first = {"0", "1", "2", "?"}  # set for the first digit of hour
    if time[0] == "?":
        if time[1] in first:
            time = "2" + time[1:]
        else:
            time = "1" + time[1:]
    if time[1] == "?":
        if time[0] == "2":
            time = time[0] + "3" + time[2:]
        else:
            time = time[0] + "9" + time[2:]
    if time[3] == "?":
        time = time[:3] + "5" + time[4:]
    if time[4] == "?":
        time = time[:4] + "9"
    return time


print(maximumTime("?4:5?"), maximumTime("23:5?"), maximumTime("2?:22"), maximumTime("0?:??"), maximumTime("??:??"))
