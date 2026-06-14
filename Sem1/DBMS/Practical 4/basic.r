# This File contains basic R commands for data types, structures, and plotting.

x <- 10.5
y <- 5L
z <- "Hello"
flag <- TRUE

# Check Types
typeof(x)
class(z)
is.numeric(z)
is.character(z)

# Print Values
print(x)
print(paste("The value of y is", y))

# Data Structures
# Vector
v <- c(1,2,3,4)
print(v)

# Matrix
m <- matrix(1:6, nrow=2, ncol=3)
print(m)

# List
l <- list(name="Rishabh", age="22", scores=c(88,92,95))
print(l)

# Factor
colors <- factor(c("red","blue","yellow","green"))
print(colors)
levels(colors)

# Data Frame
df <- data.frame(Name=c("A","B","C"), Age=c(20,21,22))
print(df)

# Table
data <- c("A", "B", "A", "C", "A")
print(table(data))

# Combining data
x <- c(1,2,3)
y <- c(4,5,6)

c_mat <- cbind(x, y)

r_mat <- rbind(x, y)

print(c_mat)
print(r_mat)

# Managing Objects
data()           # list built-in datasets
rm(x)            # remove object x
rm(list=ls())    # remove all objects from environment


# Attaching Detaching Data
data(mtcars)
attach(mtcars)
mean(mpg)
detach(mtcars)

# Reading data from console
x <- scan()     # Enter numbers in console, press Enter twice to stop

# Reading and Writing Data
df2 -> read.csv("data.csv", header=TRUE)
head(cf)

write.csv("output.csv", row.names=FALSE)

# Reading XL
library(readxl)
data_excel <- read_excel("data.xlsx", sheet = 1)

# Simple Scatter Plot
data(mtcars)
plot(mtcars$wt, mtcars$mpg,
     main= "MPG vs Weight",
     xlab= "Weight (1000 lbs)",
     ylab= "Miles per Gallon",
     col= "red",
     pch = 19) # Solid Circle Points

# Line Plot
x <- 1:10
y <- x^2
plot(x,y, 
     type = "l",
     col="red",
     lwd= 2,
     main= "Line Plot Example",
     xlab="X",
     ylab="Y=X^2")

# Histogram
hist(mtcars$mpg,
     main = "Histogram Example",
     xlab="Miles per galon",
     col="lightblue",
     border="black")

# Box Plot
boxplot(mtcars$mpg ~ mtcars$cyl,
        main = "MPG by Cylinder Count",
        xlab = "Number of Cylinders",
        ylab = "Miles Per Gallon",
        col = c("skyblue", "lightgreen", "pink"))

# Bar Plot
counts <- table(mtcars$cyl)
barplot(counts,
        main = "Car Counts by Cylinders",
        xlab = "Cylinders",
        ylab = "Frequency",
        col = "orange")


# Exporting Plots
png("plot.png", width=800, height=600)
plot(mtcars$wt, mtcars$mpg)
dev.off()