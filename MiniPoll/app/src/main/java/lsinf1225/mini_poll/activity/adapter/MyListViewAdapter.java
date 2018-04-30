package lsinf1225.mini_poll.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import lsinf1225.mini_poll.R;
import lsinf1225.mini_poll.model.User;

/**
 * Gère l'affichage personnalisé de notre liste.
 * <p>
 * Cette classe permet de créer un Adapter personnalisé pour notre liste d'éléments de collection.
 * De cette manière il nous est possible d'utiliser un layout particulier (ici
 * collected_item_row.xml) pour chaque ligne reprenant le nom de l'élément et sa note (rating).
 *
 * @author Damien Mercier
 * @version 1
 * @see <a href="http://d.android.com/reference/android/widget/Adapter.html">Adapter</a>
 * @see <a href="http://d.android.com/reference/android/widget/BaseAdapter.html">BaseAdapter</a>
 */
public class MyListViewAdapter extends BaseAdapter {
    /**
     * Permet d'instancier un fichier xml de layout dans une vue.
     */
    private final LayoutInflater mInflater;

    /**
     * Liste des éléments de collection à mettre dans la liste.
     */
    private ArrayList<User> users;

    /**
     * Constructeur.
     *
     * @param context        Contexte de l'application.
     * @param user Liste des éléments de collection à placer dans la liste.
     */
    public MyListViewAdapter(Context context, ArrayList<User> user) {
        mInflater = LayoutInflater.from(context);
        this.users = user;
    }

    @Override
    public int getCount() {

        return users.size();
    }

    @Override
    public Object getItem(int position) {

        return users.get(position);
    }

    @Override
    public int getItemId(int position) {

        return users.get(position).getId();
    }

    /**
     * Remplit chaque ligne de la liste avec un layout particulier.
     * <p>
     * Cette méthode est appelée par Android pour construire la vue de la liste (lors de la
     * construction de listview).
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Si la vue n'a pas encore été créé (typiquement lors du première affichage de la liste).
        // Android recycle en effet les layout déjà chargés des éléments de la liste (par exemple
        // lors du changement de l'ordre dans la liste.)

        if (convertView == null) {
            // Création d'un nouvelle vue avec le layout correspondant au fichier xml
            convertView = mInflater.inflate(R.layout.collect_item_row, parent, false);
        }

        // Récupération des deux éléments de notre vue dans le but d'y placer les données.
        TextView nameTextView = convertView.findViewById(R.id.show_row_name);
        RatingBar ratingBar = convertView.findViewById(R.id.show_row_rating);

        // Récupération et placement des données.
        User user = users.get(position);
        nameTextView.setText(user.getPrenom());
        return convertView;
    }

    /**
     * Change la liste des éléments de collection affichée.
     * <p>
     * Permet de changer complètement la liste des éléments affichés dans la liste.
     *
     * @param newUser La nouvelle liste des éléments de collection à afficher.
     */
    public void setSongs(ArrayList<User> newUser) {
        this.users = newUser;
        notifyDataSetChanged();
    }
}
