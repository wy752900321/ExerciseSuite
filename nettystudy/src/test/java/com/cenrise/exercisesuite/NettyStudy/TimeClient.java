package com.cenrise.exercisesuite.NettyStudy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
	public void connect(int port, String host) throws Exception {
		// 创建客户端处理I/O读写的NioEventLoopGroup线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						/**
						 * initChannel作用是当创建NioSocketChannel成功之后，
						 * 在初始化它的时候将它的ChannelHandler设置到
						 * ChannelPipeline中，用于处理网络I/O事件
						 */
						@Override
						public void initChannel(SocketChannel ch)
								throws Exception {
							ch.pipeline().addLast(new TimeClientHandler());
						}
					});
			// 客户端启动辅助类设置完成之后，调用connect方法发起异步连接，然后调用同步方法等待连接成功。
			ChannelFuture f = b.connect(host, port).sync();
			// 最后，当客户端连接关闭之后，客户端主函数退出，在退出之前，释放NIO线程组的资源。
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放NIO线程组
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {
				// 采用默认值
			}
		}
		new TimeClient().connect(port, "127.0.0.1");
	}
}
