package org.emamotor.java.jcip.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * このアノテーションが適用されたクラスはスレッドセーフではありません。
 * このアノテーションは主として、非スレッドセーフのクラスの分類のためにあります。
 * そういったクラスは、妥当な理由なしにスレッドセーフであるとするのは悪い認識であるにも関わらず、
 * スレッドセーフであると想定されることがあります。
 *
 * @See ThreadSafe
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotThreadSafe {
}
