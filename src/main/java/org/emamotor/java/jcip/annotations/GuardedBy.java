package org.emamotor.java.jcip.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * このアノテーションが適用されたフィールドやメソッドは、
 * 組み込みの(同期)ロックや明示的な java.util.concurrent.Lock といった、
 * 特定のロック処理が行われた時にだけアクセスされます。
 *
 * 引数はロックがアノテートされたフィールドやメソッドをガードすることを決定します。
 * <ul>
 * <li>
 * TODO 未訳
 * <code>this</code> : The intrinsic lock of the object in whose class the field is defined.
 * </li>
 * <li>
 * <code>class-name.this</code> : インナークラスに対して、'this' の曖昧さをなくすために必要です。
 * <em>class-name.this</em> は 'this' 参照が意図するものを明確にします。
 * </li>
 * <li>
 * <code>itself</code> : フィールドのみに参照されます。そのフィールドへのオブジェクトを参照します。
 * </li>
 * <li>
 * <code>field-name</code> : ロックオブジェクトは、<em>field-name</em> で特定される
 * インスタンスまたはスタティックなフィールドによって参照されます。
 * </li>
 * <li>
 * <code>class-name.field-name</code> : ロックオブクトは、<em>field-name</em> で特定される
 * スタティックなフィールドによって参照されます。
 * </li>
 * <li>
 * <code>method-name()</code> : ロックオブジェクトは名前付き nil-ary メソッドが呼ばれることで返されます。
 * </li>
 * <li>
 * <code>class-name.class</code> : 特定のクラスのクラスオブジェクトがロックオブジェクトとして利用されることを想定します。
 * </li>
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuardedBy {
    String value();
}
