l1 = []

with open('input.txt', 'r') as file:
    for line in file:
        line = line.strip('\n').split(' ')
        l1.append(line)
    print(l1)