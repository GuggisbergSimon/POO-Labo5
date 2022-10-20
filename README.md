# Rapport Labo 5

Le laboratoire s'est articulé autour de deux classes principales :

- Matrice (classe contenant un tableau à deux dimensions
  représentant la matrice ainsi que la valeur modulo)
- Operator (classe abstraite)
    - Plus (addition)
    - Minus (soustraction)
    - Mult (multiplication)

La création des matrices se fait de deux manières. Soit de
manière aléatoire, soit en se basant sur un array existante à deux
dimensions. Dans le cas où celle-ci ne serait pas régulière,
on la parcoure une première fois pour déterminer la largeur, N,
maximum, puis on la parcoure une seconde fois pour copier les
valeurs. Si ces valeurs n'existent pas, car dimensions non
régulières et inférieures à celle maximum, alors on attribue 0
comme valeur.

Pour effectuer une opération, il faut passer par une méthode
d'une matrice (plus, minus et multiply).
Ces méthodes vont ensuite appeler la méthode privée "operate" en lui 
passant en parametre l'opérateur du quel on va appeler la méthode 
op d'Operator, méthode abstraite qui doit être redéfinie par chacun de 
ses héritiers. Cela permet la réutilisation du code d'itération sur 
les matrices en déléguant la tâche des opérations aux héritiers. 
De cette manière il serait trivial d'ajouter des nouvelles opérations, 
tel que demandé dans la consigne du laboratoire. De plus, nous avons 
ajouté un opérateur toString pour pouvoir imprimer de manière plus 
commode les opérations effectuées.