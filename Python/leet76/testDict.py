tinydict = {'name': 'runoob', 'likes': 123, 'url': 'www.runoob.com'}
print(tinydict)
tinydict1 = {'abc': 456}
print(tinydict1)
tinydict2 = {'abc': 123, 98.6: 37}
print(tinydict2)

# 使用大括号 {} 来创建空字典
emptyDict = {}
# 打印字典
print(emptyDict)

# 查看字典的数量
print("Length:", len(emptyDict))

# 查看类型
print(type(emptyDict))

emptyDict = dict()

# 打印字典
print(emptyDict)

# 查看字典的数量
print("Length:", len(emptyDict))

# 查看类型
print(type(emptyDict))

tinydict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

print("tinydict['Name']: ", tinydict['Name'])
print("tinydict['Age']: ", tinydict['Age'])

tinydict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

# print("tinydict['Alice']: ", tinydict['Alice'])

tinydict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

tinydict['Age'] = 8               # 更新 Age
tinydict['School'] = "菜鸟教程"  # 添加信息


print("tinydict['Age']: ", tinydict['Age'])
print("tinydict['School']: ", tinydict['School'])

tinydict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

del tinydict['Name']  # 删除键 'Name'
tinydict.clear()     # 清空字典
del tinydict         # 删除字典

print("tinydict['Age']: ", tinydict['Age'])
print("tinydict['School']: ", tinydict['School'])

tinydict = {'Name': 'Runoob', 'Age': 7, 'Name': '小菜鸟'}

print("tinydict['Name']: ", tinydict['Name'])

tinydict = {['Name']: 'Runoob', 'Age': 7}

print("tinydict['Name']: ", tinydict['Name'])
