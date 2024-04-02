lettersA = {"A", "B", "C", "D"}
lettersB = {"C", "D", "E", "F"}

union = lettersA | lettersB
intersection = lettersA & lettersB
differenceAB = lettersA - lettersB
differenceBA = lettersB - lettersA

print(f"Union = {union}")  # {A, B, C, D, E, F} (order not guaranteed)
print(f"Intersection = {intersection}")  # {C, D} (order not guaranteed)
print(f"Difference A - B = {differenceAB}")  # {A, B} (order not guaranteed)
print(f"Difference B - A = {differenceBA}")  # {E, F} (order not guaranteed)
