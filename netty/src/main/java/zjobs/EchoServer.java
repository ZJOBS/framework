package zjobs;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("用法" + EchoServer.class.getSimpleName() + "<port>");
            return;
        }
        int port = Integer.parseInt(args[0]);//设置端口值
        new EchoServer(port).start();//呼叫服务器
    }

    public void start() throws Exception {
        try {
            NioEventLoopGroup group = new NioEventLoopGroup();//创建EventGroup
            ServerBootstrap b = new ServerBootstrap();//创建ServerBootstrap
            b.group(group)
                    .channel(NioServerSocketChannel.class)//指定NIO的channel
                    .localAddress(new InetSocketAddress(port))//设置socket使用端口
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        /*
                         **
                         *内部类
                         * */
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName() + "开始监听" + f.channel().localAddress());
            f.channel().closeFuture().sync();
        } finally {


        }
    }

}
