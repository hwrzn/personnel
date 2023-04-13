package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import java.time.LocalDate;
import personnel.SauvegardeImpossible;

public class EmployeConsole {
	private Option afficher(final Employe employe) {
		return new Option("Afficher l'employé", "l", () -> {
			System.out.println("Date d'arrivée :" + employe.getDateArrivee());
			System.out.println("Date de départ :" + employe.getDateDepart());
		});
	}

	ListOption<Employe> editerEmploye() {
		return (employe) -> editerEmploye(employe);
	}

	Option editerEmploye(Employe employe) {
		Menu menu = new Menu("Gérer le compte " + employe.getNom(), "c");
		menu.add(afficher(employe));
//			menu.add(changerNom(employe));
		menu.add(modifierEmploye(employe));
		menu.add(supprimerEmploye(employe));
//			menu.add(changerPrenom(employe));
//			menu.add(changerMail(employe));
//			menu.add(changerPassword(employe));
//			menu.add(changerDateDepart(employe));
		menu.addBack("q");
		return menu;
	}

	Option modifierEmploye(Employe employe) {
		Menu menu = new Menu("Gérer le compte " + employe.getNom(), "c");
		menu.add(afficher(employe));
		menu.add(changerNom(employe));
		menu.add(changerPrenom(employe));
		menu.add(changerMail(employe));
		menu.add(changerPassword(employe));
		menu.add(changerDateDepart(employe));
		menu.add(supprimerEmploye(employe));
		menu.addBack("q");
		return menu;
	}

	private Option changerNom(final Employe employe) {
		return new Option("Changer le nom", "n", () -> {
			employe.setNom(getString("Nouveau nom : "));
		});
	}

	private Option changerPrenom(final Employe employe) {
		return new Option("Changer le prénom", "p", () -> {
			employe.setPrenom(getString("Nouveau prénom : "));
		});
	}

	private Option changerMail(final Employe employe) {
		return new Option("Changer le mail", "e", () -> {
			employe.setMail(getString("Nouveau mail : "));
		});
	}

	private Option changerPassword(final Employe employe) {
		return new Option("Changer le password", "x", () -> {
			employe.setPassword(getString("Nouveau password : "));
		});
	}

	private Option changerDateDepart(final Employe employe) {

		return new Option("Changer la date de départ", "d", () -> {
			try {
				employe.setDateArrivee(LocalDate.parse(getString("Date de départ (AAAA-MM-JJ) : ")));
			} catch (SauvegardeImpossible e) {
				System.err.println("erreur sur la saisie des dates ");
			}
		});
	}

	private Option supprimerEmploye(final Employe employe) {
		return new Option("Supprimer l'employé", "s", () -> {
			employe.remove();
		});
	}
}