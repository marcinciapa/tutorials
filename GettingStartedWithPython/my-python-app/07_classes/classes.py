class Phone:

    def __init__(self, brand, price):
        self.brand = brand
        self.price = price

    def call(self, phone_number):
        print(f"{self.brand} is calling {phone_number}")


iphone = Phone("Iphone 7+", 300)
samsung = Phone("Samsung S20", 1400)

print(iphone)  # class and address in memory
print(samsung)  # class and address in memory

print()
print(iphone.brand)
print(iphone.price)
iphone.call(999)

print()
print()
print(samsung.brand)
print(samsung.price)
samsung.call(112)
