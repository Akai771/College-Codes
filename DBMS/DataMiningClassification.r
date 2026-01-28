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

predicted_weight <- predict(model, newdata = x22)
predicted_weight

# -----------------------------------------------------------------------------------
# Naive Bayes Algorithm
ird<-iris
ird

irr<-ird[sample(nrow(ird)),]
irr
head(irr)
tail(irr)

# splitting the data
train=irr[1:120,]
train
test=irr[121:150,]
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

ird <- iris
ird

shuffle_data <- ird[sample(nrow(ird)), ]
shuffle_data


iris_train <- shuffle_data[1:100, ]
iris_test <- shuffle_data[101: 150, ]

dim(iris_train)
dim(iris_test)

install.packages("rpart")
install.packages("rpart.plot")

library(rpart)
library(rpart.plot)

model <- rpart(Species ~ ., data = iris_train, method = "class")
model

rpart.plot(model, type = 0, extra = 102)
rpart.plot(model, type = 1, extra = 102)
rpart.plot(model, type = 2, extra = 102)
rpart.plot(model, type = 3, extra = 102)
rpart.plot(model, type = 4, extra = 104)

predicted <- predict(model, iris_test, type = "class")

table(Actual = iris_test$Species, Predicted = predicted)