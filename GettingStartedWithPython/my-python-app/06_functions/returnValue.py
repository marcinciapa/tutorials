def is_adult(age):
    if age >= 16:
        print("adult")
    else:
        print("not yet an adult")


is_adult(10)  # not yet an adult
is_adult(45)  # adult


def is_adult(age):
    if age >= 16:
        return True
    else:
        return False


result = is_adult(45)
print(result)  # True
result = is_adult(10)
print(result)  # False


def is_adult(age):
    return age >= 16


result = is_adult(45)
print(result)  # True
result = is_adult(10)
print(result)  # False


def convert_gender(gender="unknown"):
    if gender.upper() == "M":
        return "Male"
    elif gender.upper() == "F":
        return "Female"
    else:
        return gender


print(convert_gender("M"))  # Male
print(convert_gender("F"))  # Female
print(convert_gender("f"))  # Female
print(convert_gender())  # unknown
print(convert_gender("non-binary"))  # non-binary
