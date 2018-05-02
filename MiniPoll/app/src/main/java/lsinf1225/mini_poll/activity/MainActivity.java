package lsinf1225.mini_poll.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lsinf1225.mini_poll.MiniPollApp;
import lsinf1225.mini_poll.R;
import lsinf1225.mini_poll.model.User;

/**
 * Gère l'affichage du menu principal de l'application.
 *
 * @author Margaux GERARD, Loïc QUINET, Félix DE PATOUL, Benoît MICHEL, Arnaud CLAES
 * @version 1
 * 29 avril 2018
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Affichage du message de bienvenue.
        TextView welcomeTxt = findViewById(R.id.welcomeTxt);
        welcomeTxt.setText(getString(R.string.main_activity_welcome_partie1) + " " + User.getConnectedUser().getPrenom());

    }


    /*
     * @note Les méthodes show, search, add et logout sont appelées lors d'un clic sur les boutons
     * correspondant grâce à l'attribut onClick présent dans les fichiers de layout.
     *
     * Lire http://developer.android.com/reference/android/R.attr.html#onClick
     */

    /**
     * Lance l'activité d'affichage de la liste des éléments.
     */
    public void show(View v) {
        Intent intent = new Intent(this, ShowListActivity.class);
        startActivity(intent);
    }

    /**
     * Lance l'activité de consultation et de modification du profil.
     */
    public void seeProfile(View v) {
        Intent intent = new Intent(this, ConsulterProfilActivity.class);
        startActivity(intent);
    }

    /**
     * Lance l'activité de consultation et de modification de la liste d'amis.
     */
    public void seeFriends(View v) {
        Intent intent = new Intent(this, ConsulterProfilActivity.class);
        startActivity(intent);
    }

    /**
     * Lance l'activité de réponse aux sondages par accord.
     */
    public void answerAgreement(View v) {
        Intent intent = new Intent(this, ReponseSondageActivity.class);
        startActivity(intent);
    }

    /**
     * Lance l'activité de réponse aux questionnaires.
     */
    public void answerQuestionnary(View v) {
        Intent intent = new Intent(this, ReponseQuestActivity.class);
        startActivity(intent);
    }

    /**
     * Lance l'activité de réponse aux demandes d'aide.
     */
    public void answerHelp(View v) {
        Intent intent = new Intent(this, ReponseAideActivity.class);
        startActivity(intent);
    }

    /**
     * Déconnecte l'utilisateur actuellement connecté et retourne vers l'écran de connexion.
     */
    public void logout(View v) {
        User.logout();
        finish();
    }

    /**
    public void modifier(View v) {
        Intent intent = new Intent(this, ModifierProfilActivity.class);
        startActivity(intent);
    }

    public void creer(View v) {
        Intent intent = new Intent(this, CreationActivity.class);
        startActivity(intent);
    }

    /**
     * Lance l'activité de recherche d'un élément.
     */
    /**
    public void search(View v) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    */

    /**
     * Désactive le bouton de retour. Désactive le retour à l'activité précédente (donc l'écran de
     * connexion dans ce cas-ci) et affiche un message indiquant qu'il faut se déconnecter.
     */
    @Override
    public void onBackPressed() {
        // On désactive le retour (car on se trouve au menu principal) en ne faisant
        // rien dans cette méthode si ce n'est afficher un message à l'utilisateur.
        MiniPollApp.notifyShort(R.string.main_back_button_disable);
    }

}
