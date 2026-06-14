import re

text="My house no is 404"

pattern=r'\d+'

result=re.findall(pattern,text)

print(result)
