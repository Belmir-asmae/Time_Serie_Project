# Serie-time-event
ce projet  réalise un système d’enregistrement et de gestion de séries temporelles , en utilisant le framework Spring Boot.
Une série temporelle est une liste de couple date → valeur. On parlera d’événement
de manière générale. La valeur est classiquement une mesure numérique. Une telle
série peut ainsi service à enregistrer tout type de mesure (la température extérieure,
le poids, la distance parcourue pendant le sport, etc.) Par ailleurs, une série possède
aussi un titre et une description.
L’utilisateur peut créer et supprimer des séries. Il peut modifier le titre et la
description d’une série existante. Il peut aussi ajouter des événements à une série,
modifier un événement existant, ou le supprimer.
Un événement peut aussi être associé à des étiquettes (tag) quelconques, ainsi
qu’un commentaire optionnel. 
Le système doit en outre être multiutilisateurs, chaque utilisateur ayant son ensemble de séries.
