<script>
   function validate()
   {
    var matricule = document.Incription.matricule;
    var nom = document.Incription.nom;
    var prenom = document.Incription.matricule;
    var genre = document.Incription.prenom;
    var adresse = document.Incription.genre;
    var age = document.Incription.adresse;
    var classe = document.Incription.age;
    var frais = document.Incription.classe;
    var date = document.Incription.frais;
    var date = document.Incription.date;


    if (matricule.value == "")
    {
     window.alert("Bien Vouloir entrer le Matricule ?");
     matricule.focus();
     return false;
    }
    if (nom.value == "")
    {
     window.alert("Bien Vouloir entrer le Nom?");
     nom.focus();
     return false;
    }
    if (prenom.value == "")
    {
     window.alert("Bien Vouloir entrer le Prenom ?");
     prenom.focus();
     return false;
    }
    if (genre.value == "")
    {
     window.alert("Bien Vouloir entrer le Genre?");
     genre.focus();
     return false;
    }
    if (adresse.value == "")
    {
     window.alert("Bien Vouloir entrer l'Adresse?");
     adresse.focus();
     return false;
    }
    if (age.value == "")
    {
     window.alert("Bien Vouloir entrer l'Age?");
     age.focus();
     return false;
    }
    if (classe.value == "")
    {
     window.alert("Bien Vouloir entrer la classe?");
     classe.focus();
     return false;
    }
    if (frais.value == "")
    {
     window.alert("Bien Vouloir entrer le Frais?");
     frais.focus();
     return false;
    }
    if (date.value == "")
    {
     window.alert("Bien Vouloir entrer le Date?");
     date.focus();
     return false;
   }
}

</script>
