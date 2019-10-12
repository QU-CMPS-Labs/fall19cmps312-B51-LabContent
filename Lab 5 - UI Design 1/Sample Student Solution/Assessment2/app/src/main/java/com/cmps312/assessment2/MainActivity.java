package com.cmps312.assessment2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.exit)
            finish();
        return super.onOptionsItemSelected(item);
    }
}


//TODO : You can copy from here the content

/*

Emblem Launch

Fans around the world are gearing up for the FIFA World Cup Qatar 2022™. As the tournament fast approaches, the newly revealed emblem will serve as a beacon to fans across the globe, drawing them to a new type of FIFA World Cup™, where everything is within easy reach.

The story behind the emblem
The emblem was inspired by traditional woolen shawls worn during the winter months – when the FIFA World Cup 2022™ will take place – in Qatar and around the world.

الإعلان عن الشعار
المشجعون من كافة أنحاء العالم متحمسون لكأس العالم FIFA قطر ٢٠٢٢™. ومع اقتراب موعد البطولة، سيكون الشعار المعلن عنه حديثاً بمثابة منارة للمشجعين من جميع أنحاء العالم، إذ سيجذبهم إلى نوع جديد من كأس العالم FIFA™ حيث يسهل الوصول إلى كل شيء.


القصة وراء الشعار
الشعار مستوحى من الشال الصوفي التقليدي الذي يرتديه الناس في قطر وفي جميع أنحاء العالم في أشهر الشتاء،  الفصل الذي ستقام خلاله كأس العالم FIFA قطر ٢٠٢٢™.

كما أن الخط الذي صُمم لتكتمل به تفاصيل الشعار يرمز أيضاً إلى التراث القطري، مع لمسات حديثة تتجه به نحو العالمية. فهو مزيج متناغم بين الخط العربي التقليدي ولغات عالمية أخرى من خلال استخدام عناصر مثل الكشيدة، وهي التطويل الذي يضاف بين الحروف لإضفاء مزيد من المرونة والجمالية على الكلمات.
 */

