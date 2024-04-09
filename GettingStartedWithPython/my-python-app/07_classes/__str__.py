class Phone:

    def __init__(self, name):
        self.name = name

    def rename(self, new_name):
        self.name = new_name

    # def __str__(self) -> str:  # alternatively, indicates return type
    def __str__(self):
        return self.name


iphone = Phone("iphone")
samsung = Phone("samsung")

print(iphone)
print(samsung)
