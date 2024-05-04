library(gapminder)
library(here)
library(socviz)
library(ggplot2)
library(tidyverse)
library(survey)
library(scales)
library(fs)
library(tidyverse)
library(readr)
library(dplyr)
library(stringr)
library(data.table)
library(gridExtra)
library(RColorBrewer)
# quesions overlapping add overarching title, how do i combined and add coloumsn
## for loop incremental cases



##How does the location of a game, 
##home vs away, have an effect on the performance 
##of the hockey teams when playing throughout the during the 2015 2016  reagular season, 
##measured by the frequency of goals scored in the game?
##Home ice advantage

game <- read.csv("game.csv")
##View(game)

team_info <- read.csv("team_info.csv")
##View(team_info)



team_info %>% head()
game_df<-merge(game,team_info, by.x=6, by.y=1)
game_df2<-merge(game_df,team_info, by.x=6, by.y=1, suffixes('home','away'))


##joined_df<- merge(game,team_info)

less<- select(game_df2,'season','type','home_team_id','away_team_id','away_goals','home_goals','teamName.x','teamName.y')
##View(less)

names(less)[8] <- 'Away Team Name'
names(less)[7] <- 'Home Team Name'


## we are going to specifially be looking at the 2015-16 season
game1516 <- filter(less, season=='20152016' & type =='R')
##View(game1516)

df<-game1516[order(game1516$home_team_id),]
##View(df)


##distribution of goals

p <- ggplot(data = df, mapping = aes(x=game1516$away_goals))+ geom_bar(fill= "Red") + ylim(0,320)+ scale_x_continuous(breaks = c(0,1,2,3,4,5,6,7,8,9) )+
  labs(x = "Away goals", y = "Frequency") 

r <- ggplot(data = df, mapping = aes(x=game1516$home_goals))+ geom_bar( fill = " light blue")+ ylim(0,320)+ scale_x_continuous(breaks = c(0,1,2,3,4,5,6,7,8,9,10) )+
  labs(x = "Home goals", y = "Frequency") 
                                                                                                                         
      
finalgames <-grid.arrange(p, r, ncol=2) 
##mtext("Distribution of Home vs Away Goals")
#mtext("Title for Two Plots", outer = TRUE, cex = 1.5)




##average goals per team 
##home team
df2 <- df %>% group_by(home_team_id,`Home Team Name`) %>% 
  summarise(mean(home_goals),
            .groups = 'drop') %>%
  as.data.frame()

##View(df2)


w<-ggplot(data = df2, aes(x = df2$`mean(home_goals)`, y = df2$`Home Team Name`,fill=df2$`Home Team Name`)) + 
  geom_bar(stat = "identity")+ 
  theme(legend.position="none")+
  labs(x = "Average goals", y = "Home Team Name",title ="Average Goals Scored in Home games") 


##average goals by away team
df3 <- df %>% group_by(away_team_id,`Away Team Name`) %>% 
  summarise(mean(away_goals),
            .groups = 'drop') %>%
  as.data.frame()


f<-ggplot(data = df3, aes(x = df3$`mean(away_goals)`, y = df3$`Away Team Name`)) + 
  geom_bar(stat = "identity")+ 
  theme(legend.position="none")+
  labs(x = "Average goals", y = "Away Team Name",title ="Average Goals Scored in Away games") 


finalgames2 <-grid.arrange(w, f, nrow=2) 

##allowed by each team 
df4 <- df %>% group_by(home_team_id,`Home Team Name`) %>% 
  summarise(mean(away_goals),
            .groups = 'drop') %>%
  as.data.frame()

m<-ggplot(data = df4, aes(x = df4$`mean(away_goals)`, y = df4$`Home Team Name`)) + 
  geom_bar(stat = "identity")+ 
  theme(legend.position="none")+
  labs(x = "Average goals", y = "Home Team Name",title ="Average Goals allowed in Home games") 

View(m)
df5 <- df %>% group_by(away_team_id,`Away Team Name`) %>% 
  summarise(mean(home_goals),
            .groups = 'drop') %>%
  as.data.frame()

d<-ggplot(data = df5, aes(x = df5$`mean(home_goals)`, y = df5$`Away Team Name`)) + 
  geom_bar(stat = "identity",fill=df5$away_team_id)+ 
  theme(legend.position="none")+
  labs(x = "Average goals", y = "Away Team Name",title ="Average Goals allowed in Away games") 

finalgames3 <-grid.arrange(m, d, nrow=2) 
##Distribution of point differential
##how much do teams ushually win/lose by


game1516$point_diff <- game1516$home_goals - game1516$away_goals

ggplot(game1516, aes(x = point_diff))+
  geom_histogram(binwidth=1,fill=" orange",color = "black")+
  scale_x_continuous(breaks = seq(-10, 10, 1), lim = c(-10, 10))+
  labs(title ="NHL Point Differential (Negative Home team Loses, Positive Home team Wins)") 






