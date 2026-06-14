import matplotlib.pyplot as plt
import numpy as np

# ══════════════════════════════════════════════════════════════
#  LINE PLOT
# ══════════════════════════════════════════════════════════════

x = np.arange(0, 10)
y = np.arange(11, 21)

plt.plot(x, y)          # basic line
plt.plot(x, y, 'd')     # diamond markers, default color
plt.plot(x, y, 'rd')    # red diamonds

# ─── Multiple lines with styling ─────────────────────────────

x  = [1,2,3,4,5]
y1 = [2,4,6,8,10]
y2 = [1,3,5,4,7]

plt.plot(x, y1, color='blue',   label='Line1', marker='o')
plt.plot(x, y2, color='orange', label='Line2', marker='s')
plt.title('Multiple Lines')
plt.xlabel('X-axis')
plt.ylabel('Y-axis')
plt.legend()
plt.grid(True)
plt.show()

# ══════════════════════════════════════════════════════════════
#  PIE CHART
# ══════════════════════════════════════════════════════════════

sizes  = [35, 25, 15, 5, 10]
labels = ['Python','Java','C++','JS','Other']

plt.pie(
    sizes,
    labels=labels,
    autopct='%1.1f%%',            # show % on each slice
    explode=[0.05,0,0,0,0],       # pull first slice out slightly
    colors=['blue','green','yellow','orange','red'],
    shadow=True,
    startangle=90,
    counterclock=False,
    wedgeprops={'edgecolor':'white','linewidth':2}
)
plt.show()

# ══════════════════════════════════════════════════════════════
#  SCATTER PLOT
# ══════════════════════════════════════════════════════════════

x = [1,2,3,4,5,6,7]
y = [3,7,2,9,4,8,5]

plt.scatter(
    x, y,
    s=100,              # marker size
    c=y,                # color mapped to y values
    cmap='viridis',     # colormap
    alpha=0.7,          # transparency
    edgecolors='black',
    linewidths=1.5,
    marker='D'          # diamond marker
)
plt.colorbar()          # show color scale
plt.show()

# ══════════════════════════════════════════════════════════════
#  QUICK REFERENCE — common markers & colors
# ══════════════════════════════════════════════════════════════

# Markers : 'o' circle  's' square  'D' diamond  '^' triangle  '*' star
# Colors  : 'r' 'g' 'b' 'orange' 'purple' or hex '#FF5733'
# Linestyle: '-' solid  '--' dashed  ':' dotted  '-.' dash-dot
