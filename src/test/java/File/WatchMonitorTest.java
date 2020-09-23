package File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * 监听一个文件的变化或者目录的变动，包括文件的创建、修改、删除，以及目录下文件的创建、修改和删除
 */
public class WatchMonitorTest {
    // 监听指定事件
    // test里面不执行 放到main里面就ok
    @Test
    public void test01() {
        File file = FileUtil.file("/Users/lixinyu/lxy/test");
        // 指定文件或目录监听事件
        // WatchMonitor.ENTRY_CREATE 文件或目录创建的事件
        // WatchMonitor.ENTRY_DELETE 文件或目录删除的事件
        // WatchMonitor.ENTRY_MODIFY 文件修改的事件
        // WatchMonitor.ENTRY_ALL 监听所有事件
        // OVERFLOW 丢失的事件
        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);
        watchMonitor.setWatcher(new Watcher() {
            @Override
            public void onCreate(WatchEvent<?> watchEvent, Path path) {
                Object obj = watchEvent.context();
                Console.log("创建：{}-> {}", path, obj);
            }

            @Override
            public void onModify(WatchEvent<?> watchEvent, Path path) {
                Object obj = watchEvent.context();
                Console.log("修改：{}-> {}", path, obj);
            }

            @Override
            public void onDelete(WatchEvent<?> watchEvent, Path path) {
                Object obj = watchEvent.context();
                Console.log("删除：{}-> {}", path, obj);
            }

            @Override
            public void onOverflow(WatchEvent<?> watchEvent, Path path) {
                Object obj = watchEvent.context();
                Console.log("Overflow：{}-> {}", path, obj);
            }
        });
        // 设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
        watchMonitor.setMaxDepth(3);
        // 启动监听
        watchMonitor.start();
    }

    // 不必实现Watcher的所有接口，写一个继承类重写对应的方法即可，比如修改：
    @Test
    public void test02() {
        File file = FileUtil.file("/Users/lixinyu/lxy/test");
        // 指定文件或目录监听事件
        // WatchMonitor.ENTRY_CREATE 文件或目录创建的事件
        // WatchMonitor.ENTRY_DELETE 文件或目录删除的事件
        // WatchMonitor.ENTRY_MODIFY 文件修改的事件
        // WatchMonitor.ENTRY_ALL 监听所有事件
        // OVERFLOW 丢失的事件
        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);
        watchMonitor.setWatcher(new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Console.log("EVENT modify");
            }
        });
        // 设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
        watchMonitor.setMaxDepth(3);
        // 启动监听
        watchMonitor.start();
    }

    // 监听所有事件
    // 监听所有，具体处不处理取决于第二个参数
    @Test
    public void test03() {
        File file = FileUtil.file("/Users/lixinyu/lxy/test");
        WatchMonitor.createAll(file, new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Console.log("EVENT modify");
            }
        }).start();
    }

    // 延迟处理监听事件
    // DelayWatcher(事件对象，延迟时间)
    // 将短时间内相同文件多次modify的事件合并处理触发
    @Test
    public void test04() {
        WatchMonitor monitor = WatchMonitor.createAll("d:/", new DelayWatcher(new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Console.log("EVENT modify");
            }
        }, 500));
        monitor.start();
    }
}

