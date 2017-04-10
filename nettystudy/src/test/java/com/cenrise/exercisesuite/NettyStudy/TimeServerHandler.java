package com.cenrise.exercisesuite.NettyStudy;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * ChannelHandlerAdapter用于对网络事件进行读写操作
 * 
 * @author admin
 *
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// ByteBuf相当于JDK的java.nio.ByteBuffer对象，不过它提供了更加强大的功能。
		ByteBuf buf = (ByteBuf) msg;
		// 根据ByteBuf的readableBytes可以获取缓冲区可读的字数,根据可读的字节数据创建byte数组
		byte[] req = new byte[buf.readableBytes()];
		// 通过ByteBuf的readBytes方法将缓冲区中的字节数组复制到新建的byte数组中
		buf.readBytes(req);
		// 最后通过new String构造函数获取请求消息
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order: " + body);
		// 对请求消息进行判断，如果是"QUERY TIME ORDER"就创建应答消息，通过ChannelHandlerContext的write方法异步发送应答消息给客户端
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(
				System.currentTimeMillis()).toString() : "BAD ORDER";
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(resp);
	}

	/**
	 * ChannelHandlerContext调用flash方法，它的作用是将消息发送队列中的消息写入到SocketChannel中发送给对方。
	 * 从性能角度考虑，为了防止频繁地唤醒Selector进行消息发送，Netty的write方法并不直接将消息写入SocketChannel中，
	 * 调用write方法只是把待发送的消息放到发送缓冲数组中，再通过调用flush方法，将发送缓冲区中的消息全部写到SocketChannel中。
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	/**
	 * 当发生异常时，关闭ChannelHandlerContext，释放和ChannelHandlerContext相关联的句柄等资源
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}

}
