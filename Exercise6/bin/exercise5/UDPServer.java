Êþº¾   8   exercise5/UDPServer  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lexercise5/UDPServer; main ([Ljava/lang/String;)V	    java/lang/System   out Ljava/io/PrintStream;  U---------UDP Server Side App | Demonstration of UDP Server-Side Application----------
    java/io/PrintStream   println (Ljava/lang/String;)V  java/net/DatagramSocket
  !  " (I)V  ÿÿ % java/net/DatagramPacket
 $ '  ( ([BI)V
  * + , receive (Ljava/net/DatagramPacket;)V . java/lang/String
 $ 0 1 2 getData ()[B
 - 4  5 ([B)V 7 java/lang/StringBuilder 9 
Message received from client: 
 6 ;  
 6 = > ? append -(Ljava/lang/String;)Ljava/lang/StringBuilder; A .

 6 C D E toString ()Ljava/lang/String;
  G H I 
countWords (Ljava/lang/String;)I
 K M L java/lang/Integer D N (I)Ljava/lang/String; P  Number of words in sentence is  
 - R S 2 getBytes
 $ U V W 
getAddress ()Ljava/net/InetAddress;
 $ Y Z [ getPort ()I
 $ ]  ^ ([BILjava/net/InetAddress;I)V
  ` a , send
 c e d java/io/IOException f  printStackTrace args [Ljava/lang/String; portNo I datagramSocket Ljava/net/DatagramSocket; receivedBuf [B receivedPacket Ljava/net/DatagramPacket; retreiveMessage Ljava/lang/String; sendText 
sendBuffer ca Ljava/net/InetAddress; 
ClientPort 
sendPacket e Ljava/io/IOException; 
StackMapTable h
 - ~  E trim
 -  ‚ ƒ isEmpty ()Z … 	+
 - ‡ ˆ ‰ split '(Ljava/lang/String;)[Ljava/lang/String; text 
SourceFile UDPServer.java !               /     *· ±    
                 
   	      »     ³² ¶ „<» Y·  M#¼N» $Y--¾· &:,¶ )» -Y¶ /· 3:² » 6Y8· :¶ <@¶ <¶ B¶ ¸ F¸ J:² » 6YO· :¶ <¶ B¶ #¼:¶ Q:¶ T:¶ X6	» $Y¾	· \:
,
¶ _§ÿkL+¶ b±   ­ ­ c  
   R             &  , " : # V & ` ' w * } + „ . ‹ / ’ 2 ¤ 5 ª  ­ 9 ® ; ² ?    z    ³ g h    ¡ i j   ˜ k l    m n  & „ o p  : p q r  ` J s r  } - t n  ‹  u v  ’  w j 	 ¤  x p 
 ®  y z  {    ý  ÿ —  |  c 	 H I     d     *¶ }L+¶ €™ ¬+„¶ †¾¬    
       C  D  E  F         Š r      r  {    ü  -  ‹    Œ
