package com.lemobs_sigelu.gestao_estoques.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class EditTextV2 extends EditText
{
    public EditTextV2(Context context )
    {
        super( context );
    }

    public EditTextV2(Context context, AttributeSet attribute_set )
    {
        super( context, attribute_set );
    }

    public EditTextV2(Context context, AttributeSet attribute_set, int def_style_attribute )
    {
        super( context, attribute_set, def_style_attribute );
    }

    @Override
    public boolean onKeyPreIme( int key_code, KeyEvent event )
    {
        if ( event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP)
            this.clearFocus();

        return super.onKeyPreIme( key_code, event );
    }
}