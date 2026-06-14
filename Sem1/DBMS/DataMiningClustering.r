# -----------------------------------------------------------------------------------
#  DEALING WITH MISSING VALUES IN R

install.packages("Hmisc")
library(Hmisc)

x <- c(6, 2, 5, NA, 9, 2, NA)          # Numeric vector with missing values
print(x)

aq_mean <- impute(x, fun = mean)      # Replace NA with mean
print(aq_mean)

aq_median <- impute(x, fun = median)  # Replace NA with median
print(aq_median)

dat <- read.csv("missing.csv")        # Read dataset
print(dat)

srno_imputed <- impute(dat$srno, fun = mean)  # Mean imputation
print(srno_imputed)

salary_imputed <- impute(dat$Salary, fun = median)  # Median imputation
print(salary_imputed)

is.na(dat)                            # Shows TRUE/FALSE for NA values

complete.cases(dat$srno)              # TRUE if value is not NA
complete.cases(dat$Salary)

gender <- c("male", "female", "female")  # Character vector
gender_factor <- factor(gender)          # Convert to factor
print(gender_factor)

z <- c("low", "low", "high", "medium", "high")

# Explicit level ordering
z_factor <- factor(z, levels = c("low", "medium", "high"))  # <-- ADDED clarity
print(z_factor)





# -----------------------------------------------------------------------------------
# K-Means Clustering

iris_dataset <- iris
iris_features <- iris_dataset[, 1:4]
normalize <- function(x) {
  return((x - min(x)) / (max(x) - min(x)))
}
iris_normalized <- as.data.frame(lapply(iris_features, normalize))

install.packages("dplyr")
library(dplyr)

install.packages("stats")
library(stats)

kmeans_model <- kmeans(
  iris_normalized,
  centers = 3,   # number of clusters
  nstart = 10    # runs algorithm multiple times for stability
)

table(Actual_Species = iris_dataset$Species, Cluster_Assigned = kmeans_model$cluster)

install.packages("ggplot2")
library(ggplot2)

install.packages("ggfortify")
library(ggfortify)


autoplot(kmeans_model, iris_normalized, frame = TRUE)     # helps to visualize the clusters


# ---------------------------------------------------------------------------
# Hierarchical Clustering

dt <- read.csv("dataset.csv")
dt

dt <- dt[2:3]
dt

dt <- scale(dt)
dt

fdt <- dist(dt)
fdt

hcrl <- hclust(fdt, method = "complete")
hcrl

plot(hcrl)

plot(hcrl, col = c(3))

# --------------------------------------------------------
# Hierarchical Clustering on Iris Dataset

iris_features <- iris[, 1:4]  # Sepal.Length, Sepal.Width, Petal.Length, Petal.Width

iris_scaled <- scale(iris_features)
iris_scaled

iris_dist <- dist(iris_scaled)
iris_dist

iris_hc <- hclust(iris_dist, method = "complete")

plot(iris_hc, main="Dendrogram - Iris Dataset")

iris_clusters <- cutree(iris_hc, k = 3)

table(Actual_Species = iris$Species, Cluster_Assigned = iris_clusters)




# ---------------------------------------------------------------------------
# Apriori Algorithm for Association Rule Mining
# Aim: To analyze a dataset using the Apriori algorithm and discover interesting association rules that reveal relationships and patterns between different attributes in the data.

# ----------------------------------Recomended way--------------------------------------

install.packages("arules")
library(arules)

dat <- read.csv("example.csv")
dat

dim(dat)

dat_logical <- dat == "YES"
dat_logical

trans <- as(dat_logical, "transactions")
inspect(trans)

rules_default <- apriori(trans)
inspect(rules_default)

rules_custom <- apriori(
  trans,
  parameter = list(
    supp = 0.25,
    conf = 0.7
  )
)

inspect(rules_custom)
rules_final <- apriori(
  trans,
  parameter = list(
    supp = 0.25,
    conf = 0.7,
    minlen = 2,
    maxlen = 5
  )
)
inspect(rules_final)




# -------------------------------------College method (Simple way)---------------------------------
install.packages("arules")      # run only once
library(arules)

dat <- read.csv("example.csv")
dat

dim(dat)
View(dat)

rules <- apriori(dat)
inspect(rules)

rules <- apriori(dat, parameter = list(supp = 0.25, conf = 0.7))
inspect(rules)

rules <- apriori(dat, parameter = list(minlen = 2, maxlen = 5, supp = 0.25, conf = 0.7))
inspect(rules)



# -----------------------------------------------------------------------
# Apriori on string data

dat <- read.csv("ex.csv")  # reading CSV file
dat

rules <- apriori(dat)
inspect(rules)

rules <- apriori(dat, parameter = list(supp = 0.25, conf = 0.7))
inspect(rules)

rules <- apriori(dat, parameter = list(supp = 0.11, conf = 0.8))
inspect(rules)

rules <- apriori(dat, parameter = list(supp = 0.10, conf = 0.8))
inspect(rules)