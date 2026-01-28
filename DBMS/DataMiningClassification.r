# Implementation of linear regression 
x---> Height
y---> Weight

x<-c(5.2,5.5,5.8,6.0,6.4,5.1,5.4,6.4)
y<-c(64,68,70,73,76,62,64,76)
x
y
plot(x,y)
plot
plot(x,y,col='red',main="scatter plot")

model=lm(y~x)
model

# predicting the value using formula "y=mx+c"
x11<-model$coefficients[[1]]+model$coefficients[[2]]*5.5
x11

# using dataframe
x22<-data.frame(x=5.5)
x22

# -----------------------------------------------------------------------------------
# Naive Bayes Algorithm
ird<-iris
ird

irr<-ird[sample(nrow(ird)),]
irr
head(irr)
tail(irr)

# splitting the data
train=irr[1:120]
train
test=irr[121:150]
test

# installing the package for naive bayes
install.packages("e1071")
library(e1071)

# implementing naive bayes model
model=naiveBayes(Species~.,data=train)
model

# predicting or testing data
pred=predict(model,test)
pred

table(test$Species)
test$Species
table(pred)

# visualizing result with the help of confusion matrix
table(test$Species, pred)



# -----------------------------------------------------------------------------------
# K Nearest Neighbour Algorithm

iris
getwd()
read.csv('iris.csv')

var <- iris
var

table(var$Species)
str(var$Species)

shuffle_iris <-iris[sample(nrow(iris)),]
shuffle_iris

# Create Normalization
normalize <- function(x){return((x-min(x))/(max(x)-min(x)))}
iris_n <- as.data.frame(lapply(shuffle_iris[c(1,2,3,4)], normalize))
iris_n

iris_train <- iris_n[1:130,]
iris_test <- iris_n[131:150,]
iris_orig_train <- shuffle_iris[1:130,5]
iris_orig_test <- shuffle_iris[131:150,5]

# Creating A Model
install.packages("class")
library(class)
model <- knn(train = iris_train, test = iris_test, cl=iris_orig_train , k=13)
model

iris_orig_test

# Display Confusion Matrix
table(iris_orig_test, model)



# -----------------------------------------------------------------------------------
# Multi Level Regression
# In multi level regression to calculate the value of 1 variable we need more than 1 variables or 1 variable depends on more than 1 variable.

dataf <- data.frame(
    salary=c(45,67,89,90,34,54,76,84),
    exper=c(7,8,4,6,9,11,9,12),
    age=c(34,50,33,47,42,45,29,30)
)

dataf

plot(dataf$salary, dataf$exper, type="l")
plot(dataf$exper, dataf$age, type="l")
plot(dataf)

# -----------------------------------------------------------------------------------
# Decision Tree for Classification

# -------------------------------------------------------
# Step 1: Load the iris dataset
# -------------------------------------------------------
# The iris dataset is a built-in dataset in R
# It contains 150 observations and 5 columns
# (4 numeric features and 1 categorical species column)
ird <- iris

# Display the dataset
ird

# -------------------------------------------------------
# Step 2: Shuffle the dataset randomly
# -------------------------------------------------------
shuffle_data <- ird[sample(nrow(ird)), ]

# Display shuffled dataset
shuffle_data

# -------------------------------------------------------
# Step 3: Split the dataset into training and testing data
# -------------------------------------------------------
# First 100 rows are used for training
# Remaining 50 rows are used for testing

# Training data (100 records)
iris_train <- shuffle_data[1:100, ]

# Testing data (remaining 50 records)
iris_test <- shuffle_data[101: 150, ]

# Check dimensions
dim(iris_train)
dim(iris_test)

# -------------------------------------------------------
# Step 4: Install and load required packages
# -------------------------------------------------------

install.packages("rpart")
install.packages("rpart.plot")

library(rpart)
library(rpart.plot)

# -------------------------------------------------------
# Step 5: Create Decision Tree model
# -------------------------------------------------------

# Species is the target variable, All other attributes are predictors
model <- rpart(Species ~ ., data = iris_train, method = "class")

# Display model details
print(model)

# -------------------------------------------------------
# Step 6: Visualize the Decision Tree
# -------------------------------------------------------

# Different tree visualizations
rpart.plot(model, type = 0, extra = 102)
rpart.plot(model, type = 1, extra = 102)
rpart.plot(model, type = 2, extra = 102)
rpart.plot(model, type = 3, extra = 102)
rpart.plot(model, type = 4, extra = 104)

# -------------------------------------------------------
# Step 7: Predict on Test Data (optional analysis step)
# -------------------------------------------------------

# Predict species for test dataset
predicted <- predict(model, iris_test, type = "class")

# Create confusion matrix
table(Actual = iris_test$Species, Predicted = predicted)