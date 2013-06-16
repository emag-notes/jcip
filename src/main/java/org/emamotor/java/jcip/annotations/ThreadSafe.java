package org.emamotor.java.jcip.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * このアノテーションが適用されたクラスはスレッドセーフです。これは、追加の同期処理や呼び出し間の調整を行うこと無く、
 * アクセスシーケンス(パブリックなフィールドへの読み取りや書き込み、パブリックなメソッドの呼び出し)が、
 * オブジェクトを不正な状態にしたり、ランタイムによるこれらの実行のインタリーブを気にする必要がないことを意味します。
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {
}
