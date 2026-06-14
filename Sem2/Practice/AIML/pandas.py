import pandas as pd
import numpy as np

# ══════════════════════════════════════════════════════════════
#  SERIES
# ══════════════════════════════════════════════════════════════

# ─── Create ──────────────────────────────────────────────────

s = pd.Series([10, 20, 30, 40, 50])                   # default int index
s = pd.Series([10, 20, 30], index=['a','b','c'])       # custom index
s = pd.Series({'maths':95, 'physics':88, 'chem':92})  # from dict

s['b']   # access by label

# ─── Attributes ──────────────────────────────────────────────

s.values   # numpy array of values
s.index    # index labels
s.dtype    # data type
s.shape    # (n,)
s.size     # number of elements
s.name     # series name (None if unset)

# ─── Methods ─────────────────────────────────────────────────

s.head(3)        # first 3
s.tail(3)        # last 3
s.describe()     # count, mean, std, min, 25%, 50%, 75%, max
s.value_counts() # frequency of each unique value

# ══════════════════════════════════════════════════════════════
#  DATAFRAME — CREATION
# ══════════════════════════════════════════════════════════════

# Method 1: from dict
data = {'Name':['A','B','C'], 'Age':[22,22,21], 'Marks':[85,92,78]}
df = pd.DataFrame(data)

# Method 2: from list of dicts
records = [{'Name':'Arjun','CGPA':8.5}, {'Name':'Priya','CGPA':9.1}]
df = pd.DataFrame(records)

# Method 3: from numpy array
arr = np.array([[1,85,22],[2,92,25],[3,78,21]])
df = pd.DataFrame(arr, columns=['Rollno','Marks','Age'], index=['Row1','Row2','Row3'])

# Method 4: from CSV / Excel
df = pd.read_csv('data.csv')
df = pd.read_excel('data.xlsx')
df.to_csv('output.csv', index=False)   # export

# Method 5: empty, then add rows
df = pd.DataFrame(columns=['Name','Age','Marks'])
df.loc[0] = ['A', 22, 85]
df.loc[1] = ['B', 25, 92]

# Method 6: from list of tuples
tuples = [('Mohit',1,18), ('Mayuri',2,17)]
df = pd.DataFrame(tuples, columns=['Name','Rollno','Marks'])

# ─── Quick from numpy arange ──────────────────────────────────────────────────
df = pd.DataFrame(
    np.arange(20).reshape(5,4),
    columns=['M1','M2','M3','M4'],
    index=['Row1','Row2','Row3','Row4','Row5']
)

# ══════════════════════════════════════════════════════════════
#  DATAFRAME — INSPECTION
# ══════════════════════════════════════════════════════════════

df.head()       # top 5 rows
df.tail()       # bottom 5 rows
df.info()       # column types, non-null counts, memory
df.describe()   # stats: count/mean/std/min/quartiles/max

# ══════════════════════════════════════════════════════════════
#  INDEXING / SELECTION
# ══════════════════════════════════════════════════════════════

df[['col1','col2']]        # select multiple columns → DataFrame
df[1:3]                    # row slice by position
df.loc['Row2']             # row by label → Series
df.loc['Row1':'Row3']      # label range
df.iloc[2:4, 0:2]          # position slice [rows, cols]

# ══════════════════════════════════════════════════════════════
#  NaN HANDLING
# ══════════════════════════════════════════════════════════════

df.isnull()              # True where NaN
df.isnull().sum()        # count NaN per column
df.fillna(0)             # replace NaN with 0
df.fillna('Unknown')     # replace NaN with string
df.replace(np.nan, 3)    # replace NaN with 3
