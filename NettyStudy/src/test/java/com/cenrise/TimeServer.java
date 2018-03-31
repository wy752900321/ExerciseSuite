package com.cenrise;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

	public void bind(int port) throws Exception {
		// 配置服务端的NIO线程组，一个用于服务端接受客户端的连接，另一个用于进行SocketChannel的网络读写
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// ServerBootstrap,Netty用于启动NIO的辅助启动类，目的是降低服务端的开发复杂度
			ServerBootstrap b = new ServerBootstrap();
			// 将两个线程组传递到ServerBootstrap中，接着设置创建的Channel为NioServerSocketChannel，它的功能对应于JDK
			// NIO类库中的ServerSocketChannel类。
			// 然后配置NioServerSocketChannel的TCP参数，最后绑定I/O事件处理类ChildChannelHandler，它的作用类似于Reactor模式中的Handler类，主要用于处理网络I/O事件，例如
			// 记录日志，对消息进行编解码等
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new ChildChannelHandler());
			// 绑定端口，同步等待成功
			ChannelFuture f = b.bind(port).sync();
			// 等待服务端监听端口关闭之后,main函数才退出
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放线程池资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			arg0.pipeline().addLast(new TimeServerHandler());

		}

	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// 采用默认值
			}
		}
		new TimeServer().bind(port);
	}

}
