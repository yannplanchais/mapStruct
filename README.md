Projet permettant de tester les possibités de mapstruct.

les essais en cours :

- Mapping simple => 1 champ texte donne un champ Long
- Mapping en utilisant la bibliothèque Lombok
- Mapping sans utiliser les annotations
- Mapping avec le mapping d'un attribut qui se trouve être un objet.
- Mapping avec le mapping d'un attribut qui se trouve être un objet Avec des noms différents.
- Mapping avec tous les noms d'attributs sont différents.

Et
- Mapping remplacé par un mapping manuel plus tourné fonctionnel pour l'un des attributs
    => Annotation @Mapping(uses="classe") sur la classe mapper