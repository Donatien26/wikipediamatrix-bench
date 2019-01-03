# Installer
install.packages("tm")  # pour le text mining
install.packages("SnowballC") # pour le text stemming
install.packages("wordcloud") # g??n??rateur de word-cloud 
install.packages("RColorBrewer") # Palettes de couleurs
# Charger
library("tm")
library("SnowballC")
library("wordcloud")
library("RColorBrewer")

# Lire le fichier texte
filePath <- "/Users/Donatien/Desktop/test.txt"
text <- readLines(filePath)
# Charger les donn??es comme un corpus
docs <- Corpus(VectorSource(text))
toSpace <- content_transformer(function (x , pattern ) gsub(pattern, " ", x))
docs <- tm_map(docs, toSpace, "/")
docs <- tm_map(docs, toSpace, "@")
docs <- tm_map(docs, toSpace, "\\|")
# Convertir le texte en minuscule
docs <- tm_map(docs, content_transformer(tolower))
# Supprimer les nombres
docs <- tm_map(docs, removeNumbers)
# Supprimer les mots vides anglais
docs <- tm_map(docs, removeWords, stopwords("english"))
# Supprimer votre propre liste de mots non d??sir??s
docs <- tm_map(docs, removeWords, c("blabla1", "blabla2")) 
# Supprimer les ponctuations
docs <- tm_map(docs, removePunctuation)
# Supprimer les espaces vides suppl??mentaires
docs <- tm_map(docs, stripWhitespace)
# Text stemming
# docs <- tm_map(docs, stemDocument)
dtm <- TermDocumentMatrix(docs)
m <- as.matrix(dtm)
v <- sort(rowSums(m),decreasing=TRUE)
d <- data.frame(word = names(v),freq=v)
head(d, 10)

wordcloud(words = d$word, freq = d$freq, min.freq = 10,
          max.words=250, random.order=FALSE, rot.per=0.4,use.r.layout = FALSE, 
          colors=brewer.pal(8, "Dark2"))

barplot(d[1:10,]$freq, las = 2, names.arg = d[1:10,]$word,
        col ="lightblue", main ="Most frequent words",
        ylab = "Word frequencies")
base <- read.csv2("/Users/Donatien/git/wikipediamatrix-bench/wikimatrix/Stat.csv", header = TRUE, sep=";", dec=",")
