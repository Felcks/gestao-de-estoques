package com.sigelu.core.lib

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.lemobs_sigelu.gestao_estoques.R

class DialogUtil {

    companion object {

        /**
         * Cria uma caixa de texto na tela
         *
         * @param activity onde o diálogo sera plotado
         * @param tituloId texto de título
         * @param mensagemId texto da mensagem
         * @param positiveButtonTextId texto do botão positivo (a direita)
         * @param positiveButtonAcao função chamada caso o usuário aperte positivo
         * @param negativeButtonTextId texto do botão negativo (a esquerda)
         * @param negativeButtonAcao função chamada caso o usuário aperte negativo
         * @param cancelavel torna a caixa cancelável ou não
         */
        fun buildAlertDialog(
                activity: Activity,
                @StringRes
                tituloId: Int,
                @StringRes
                mensagemId: Int,
                positiveButtonTextId: Int?,
                positiveButtonAcao: () -> Unit,
                negativeButtonTextId: Int?,
                negativeButtonAcao: () -> Unit,
                cancelavel: Boolean = false): AlertDialog {

            val positiveButtonOnClickListener = DialogInterface.OnClickListener { dialog, _ ->
                positiveButtonAcao()
                dialog.dismiss()
            }
            val negativeButtonClickListener = DialogInterface.OnClickListener { dialog, _ ->
                negativeButtonAcao()
                dialog.dismiss()
            }

            val alertDialogBuilder = AlertDialog.Builder(activity)
            val inflater = activity.layoutInflater
            val view = inflater.inflate(R.layout.dialogo_padrao, null)
            view.findViewById<TextView>(R.id.tv_titulo).setText(tituloId)
            view.findViewById<TextView>(R.id.tv_mensagem).setText(mensagemId)

            alertDialogBuilder.setView(view)
            if(positiveButtonTextId != null)
                alertDialogBuilder.setPositiveButton(positiveButtonTextId, positiveButtonOnClickListener)
            if(negativeButtonTextId != null)
                alertDialogBuilder.setNegativeButton(negativeButtonTextId, negativeButtonClickListener)

            alertDialogBuilder.setCancelable(cancelavel)


            return alertDialogBuilder.create()
        }

        /**
         * Cria uma caixa de texto na tela
         *
         * @param activity onde o diálogo sera plotado
         * @param titulo texto de título
         * @param mensagem texto da mensagem
         * @param positiveButtonText texto do botão positivo (a direita)
         * @param positiveButtonAcao função chamada caso o usuário aperte positivo
         * @param negativeButtonText texto do botão negativo (a esquerda)
         * @param negativeButtonAcao função chamada caso o usuário aperte negativo
         * @param cancelavel torna a caixa cancelável ou não
         */
        fun buildAlertDialog(
                activity: Activity,
                titulo: String,
                mensagem: String,
                positiveButtonTextId: Int? = null,
                positiveButtonAcao: () -> Unit,
                negativeButtonTextId: Int? = null,
                negativeButtonAcao: () -> Unit,
                cancelavel: Boolean = false): AlertDialog {

            val positiveButtonOnClickListener = DialogInterface.OnClickListener { _, _ -> positiveButtonAcao() }
            val negativeButtonClickListener = DialogInterface.OnClickListener { _, _ ->  negativeButtonAcao() }

            val alertDialogBuilder = AlertDialog.Builder(activity)
            val inflater = activity.layoutInflater
            val view = inflater.inflate(R.layout.dialogo_padrao, null)
            view.findViewById<TextView>(R.id.tv_titulo).text = titulo
            view.findViewById<TextView>(R.id.tv_mensagem).text = mensagem

            alertDialogBuilder.setView(view)
            if(positiveButtonTextId != null)
                alertDialogBuilder.setPositiveButton(positiveButtonTextId, positiveButtonOnClickListener)
            if(negativeButtonTextId != null)
                alertDialogBuilder.setNegativeButton(negativeButtonTextId, negativeButtonClickListener)

            alertDialogBuilder.setCancelable(cancelavel)

            return alertDialogBuilder.create()
        }

        fun buildAlertDialogOkCancel(
                activity: Activity,
                titulo: String,
                mensagem: String,
                positiveButtonAcao: () -> Unit,
                negativeButtonAcao: () -> Unit,
                cancelavel: Boolean = true): AlertDialog {

            return buildAlertDialog(activity, titulo, mensagem, R.string.dialogo_button_ok, positiveButtonAcao, R.string.dialogo_button_cancel, negativeButtonAcao, cancelavel)
        }

        fun buildAlertDialogSimNao(
            activity: Activity,
            titulo: String,
            mensagem: String,
            positiveButtonAcao: () -> Unit,
            negativeButtonAcao: () -> Unit,
            cancelavel: Boolean = true): AlertDialog {

            return buildAlertDialog(activity, titulo, mensagem, R.string.dialogo_button_sim, positiveButtonAcao, R.string.dialogo_button_nao, negativeButtonAcao, cancelavel)
        }

        fun buildAlertDialogOk(
                activity: Activity,
                titulo: String,
                mensagem: String,
                positiveButtonAcao: () -> Unit,
                cancelavel: Boolean = true): AlertDialog {

            return buildAlertDialog(activity, titulo, mensagem, R.string.dialogo_button_ok,  positiveButtonAcao, null, {}, cancelavel)
        }


        fun showSnackbar(
                view: View,
                @StringRes
                messageId: Int){

            val snackbar = Snackbar.make(view, messageId, Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }
}