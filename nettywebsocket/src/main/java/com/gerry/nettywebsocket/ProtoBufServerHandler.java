package com.gerry.nettywebsocket;

import com.gerry.nettywebsocket.protobuf.ReviewProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.List;

public class ProtoBufServerHandler extends ChannelInboundHandlerAdapter {
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{

        channels.add(ctx.channel());

        ReviewProto.Review review = (ReviewProto.Review)msg;
        if("Orange".equalsIgnoreCase(people.getName())){
            //   if("Orange".equals(people.getName())){
            System.out.println("accept client people:[" + people.toString() + "]");
            ctx.writeAndFlush(resp(people.getId()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }


}