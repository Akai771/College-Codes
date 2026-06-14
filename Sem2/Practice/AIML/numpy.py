import numpy as np

# ─── ARRAY CREATION ──────────────────────────────────────────────────────────

arr = np.array([1, 2, 3])                           # 1D from list
arr2d = np.array([[1,2,3],[4,5,6]])                  # 2D (matrix)
arr_float = np.array([[1,2],[3,4]], dtype=np.float64)
arr_complex = np.array([[1,2],[3,4]], dtype=complex)

# ─── CONSTANT ARRAYS ─────────────────────────────────────────────────────────

np.zeros(5)                 # [0. 0. 0. 0. 0.]
np.zeros((2,3))             # 2x3 float zeros
np.zeros((2,3), dtype=int)  # 2x3 int zeros

np.ones((2,3))              # 2x3 float ones

np.full(5, 7)               # [7 7 7 7 7]
np.full((3,3), 3.14)        # 3x3 filled with 3.14

# ─── RANGE-BASED ARRAYS ──────────────────────────────────────────────────────

np.arange(6)                # [0 1 2 3 4 5]
np.arange(1, 6)             # [1 2 3 4 5]
np.arange(0, 10, 2)         # [0 2 4 6 8]  (start, stop, step)

np.linspace(0, 1, 5)                    # [0.  0.25  0.5  0.75  1.]  — N evenly spaced
np.linspace(0, 10, 4)                   # [0.  3.33  6.67  10.]
np.linspace(0, 1, 5, endpoint=False)    # excludes endpoint → [0. 0.2 0.4 0.6 0.8]

# ─── IDENTITY / DIAGONAL ─────────────────────────────────────────────────────

np.eye(4)        # 4x4 identity  (flexible: NxM, k= for offset diagonal)
np.identity(3)   # 3x3 identity  (square only)

# ─── RANDOM ARRAYS ───────────────────────────────────────────────────────────

np.random.rand(5)                       # 5 uniform floats [0,1)
np.random.rand(2, 3)                    # 2x3 uniform floats

np.random.randint(0, 10, size=5)        # 5 random ints in [0,10)
np.random.randint(1, 100, size=(3,3))   # 3x3 random ints in [1,100)

np.random.uniform(2, 8, size=5)         # 5 floats uniformly in [2,8]

# ─── LIKE FUNCTIONS (match shape of existing array) ──────────────────────────

a = np.array([[3,6],[9,12]])
np.zeros_like(a)       # [[0,0],[0,0]]
np.ones_like(a)        # [[1,1],[1,1]]
np.full_like(a, 89)    # [[89,89],[89,89]]

# ─── ARRAY PROPERTIES ────────────────────────────────────────────────────────

a2 = np.array([[1,2,3],[4,5,6]])
a2.shape      # (2, 3)
a2.ndim       # 2
a2.dtype      # int64
a2.size       # 6   (total elements)
a2.itemsize   # 8   (bytes per element)

# ─── RESHAPE ─────────────────────────────────────────────────────────────────

np.arange(12).reshape(3, 4)    # 1D [0..11] → 3x4 matrix

# ─── ELEMENT-WISE OPERATIONS ─────────────────────────────────────────────────

a1 = np.array([1,2,3,4])
a2 = np.array([4,3,2,1])
a1 + a2    # [5,5,5,5]  — element-wise (plain list + would concatenate instead)
