package application;
	
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			  root.setStyle("-fx-background-image:url('coo.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
			  ImageView c1 = new ImageView(
						"cvv.png");
				c1.setFitWidth(300);
				c1.setFitHeight(150);
				Button btn2 = new Button("", c1);
				btn2.setOnAction(new EventHandler<ActionEvent>() {
					int k;
					int d[][];
					int f[][];
					String [] value;
					@Override
					public void handle(ActionEvent arg0) {
						BorderPane root = new BorderPane();
						root.setStyle("-fx-background-image:url('coo.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
						GridPane g=new GridPane();
						ImageView c = new ImageView(
								"startt.png");
						c.setFitWidth(200);
						c.setFitHeight(180);
						
						Button btnn = new Button("", c);
						g.add(btnn, 0, 0);
						ImageView cc = new ImageView(
								"printerr.png");
						cc.setFitWidth(200);
						cc.setFitHeight(180);
						Button btn = new Button("", cc);
						g.add(btn, 0, 3);
						g.setHgap(5);
						g.setVgap(10);
						g.setAlignment(Pos.CENTER);
						root.setCenter(g);
						Scene scene = new Scene(root,1550,800);
						primaryStage.setScene(scene);
						primaryStage.show();
						btnn.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								BorderPane root = new BorderPane();
								root.setStyle("-fx-background-image:url('coo.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
								
								GridPane g=new GridPane();
								Label label = new Label("Enter the number of coins: ");
								label.setFont(Font.font(25));
								label.setTextFill(Color.WHITE);
								label.setFont(Font.font(null, FontWeight.BOLD, label.getFont().getSize()));
								TextField number = new TextField();
								number.setMinSize(100, 40);
								g.add(label, 0, 0);
								g.add(number, 1, 0);
								Label labell = new Label("Enter the values of coins separated by , : ");
								labell.setFont(Font.font(25));
								labell.setTextFill(Color.WHITE);
								labell.setFont(Font.font(null, FontWeight.BOLD, labell.getFont().getSize()));
								TextField values = new TextField();
								values.setMinSize(100, 40);
								g.add(labell, 0, 3);
								g.add(values, 1, 3);
								 ImageView imag = new ImageView(
											"finddd.png");
									imag.setFitWidth(100);
									imag.setFitHeight(80);
									Button bt = new Button("", imag);
								
									bt.setOnAction(new EventHandler<ActionEvent>() {
										
										@Override
										public void handle(ActionEvent arg0) {
											Label lab = new Label("The maximum amount of money : ");
											lab.setTextFill(Color.WHITE);
											lab.setFont(Font.font(25));
											lab.setFont(Font.font(null, FontWeight.BOLD, lab.getFont().getSize()));
											TextField max = new TextField();
											max.setMinSize(100, 40);
											g.add(lab, 0, 5);
											g.add(max, 1,5);
											try {
											int n=Integer.valueOf(number.getText());
											k=n;
											value=values.getText().split(",");
										f=new int [n][n];
									
										    if(n%2==0 && value.length%2==0) {
										    	d=new int [n][n];
										    	for(int i=0;i<n;++i) {
										    		 for(int j=0;j<n;++j) {
										    			 if(i>j) {
										    				 d[i][j]=0;
										    			 }
										    		 }
										    	}
										    	for(int dia=0;dia<=n;++dia) {
										    		 for(int i=0;i<n-dia;++i) {
										    			int j=i+dia;
										    			if(i==j) {
										    				d[i][j]=Integer.valueOf(value[i]);
										    				f[i][j]=2;
										    			}else if(j-i==1) {
										    				int r=Math.max(Integer.valueOf(value[i]),Integer.valueOf(value[j]));
										    				d[i][j]=r;
										    			if(r==Integer.valueOf(value[i])){
										    				f[i][j]=1;	
										    				}
										    				else {
										    					f[i][j]=0;	
										    				}
										    				
										    				
										    			}
										    			else {
										    				int min=Math.min(d[i+2][j],d[i+1][j-1]);
										    				int minn=Math.min(d[i+1][j-1],d[i][j-2]);
										    				int op1=Integer.valueOf(value[i])+min;
										    				int op2=Integer.valueOf(value[j])+minn;
										    				int c=Math.max(op1, op2);
										    			    d[i][j]=c;
										    			    if(c==op1) {
										    			    	f[i][j]=1;
										    			    	if(min==d[i+2][j]) {
										    			    		f[i+1][j]=1;
										    			    	}else {
										    			    		f[i+1][j]=0;
										    			    	}
										    			    }else if (c==op2) {
										    			    	f[i][j]=0;
										    			    	
										    			    	if(minn==d[i+1][j-1]) {
										    			    		f[i][j-1]=1;
										    			    		
										    			    	}else {
										    			    		f[i][j-1]=0;
										    			    	}
										    			    }
										    			
										    			}
										    		 }
										    	}
										     
										    
										    	 max.setText(String.valueOf(d[0][n-1]));
										    
										    	
										    }else {
										    	values.setText("ERROR PLEASE TRY AGAIN");
										    	
												number.setText("ERROR PLEASE TRY AGAIN");
										    }
										   
											
										}catch(NumberFormatException e) {
											values.setText("ERROR PLEASE TRY AGAIN");
											number.setText("ERROR PLEASE TRY AGAIN");
										}
										}
										
									});
									g.setHgap(10);
									g.setVgap(10);
									ImageView back = new ImageView(
											"backk.png");
									back.setFitWidth(100);
									back.setFitHeight(80);
									Button backk = new Button("", back);
									backk.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent arg0) {
											primaryStage.setScene(scene);

										}

									});
									HBox n = new HBox();
									n.getChildren().addAll(bt, backk);
									n.setSpacing(30);
									n.setAlignment(Pos.CENTER);
									n.setPadding(new Insets(25, 25, 50, 25));
									
									root.setAlignment(n, Pos.CENTER);
									root.setBottom(n);
									g.setAlignment(Pos.CENTER);
									root.setCenter(g);
								
								
								Scene scene = new Scene(root,1550,800);
								primaryStage.setScene(scene);
								primaryStage.show();
								
							}
							
						});
						btn.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								BorderPane root = new BorderPane();
								root.setStyle("-fx-background-image:url('coo.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
								GridPane g=new GridPane(); 
								Button table =new Button("Table");
								table.setFont(Font.font(25));
								table.setMinWidth(200);
								table.setMinHeight(180);
								table.setFont(Font.font(null, FontWeight.EXTRA_BOLD, table.getFont().getSize()));
								table.setStyle("-fx-background-image:url('table.png'); -fx-background-size: 200 180; -fx-background-position: center center;");
								g.add(table, 0, 0);
							    Button play=new Button();
								play.setFont(Font.font(25));
								play.setMinWidth(200);
								play.setMinHeight(180);
								play.setFont(Font.font(null, FontWeight.EXTRA_BOLD, play.getFont().getSize()));
								play.setStyle("-fx-background-image:url('play.png'); -fx-background-size: 200 180; -fx-background-position: center center;");
								g.add(play, 0, 3);
								g.setVgap(10);
								g.setHgap(10);
								play.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										BorderPane root = new BorderPane();
										GridPane g=new GridPane();
										root.setStyle("-fx-background-image:url('coo.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
									   int i=0;
									   int j=k-1;
									   int c=k;
									 
									   Image im = new Image(
												"coinnn.jpg");
									  
									   HBox choice=new HBox();
									   choice.setAlignment(Pos.CENTER);
									   choice.setSpacing(10);
										for(int v=0;v<k;++v) {
											Button b= new Button(value[v] + "");
											b.setAlignment(Pos.CENTER);
											b.setShape(new Circle(150));
										   
										    b.setPrefSize(80,50);
										 	b.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

											choice.getChildren().add(b);
									
										}
										
										Label player1=new Label("Player 1 coins:");
										player1.setFont(Font.font(30));
										player1.setTextFill(Color.WHITE);
										player1.setFont(Font.font(null, FontWeight.BOLD, player1.getFont().getSize()));
										g.add(player1, 500, 0);
										Label player2=new Label("Player 2 coins:");
										player2.setFont(Font.font(30));
										player2.setTextFill(Color.WHITE);
										player2.setFont(Font.font(null, FontWeight.BOLD, player2.getFont().getSize()));
										g.add(player2, 500, 30);
										 g.setAlignment(Pos.CENTER);
										 g.setVgap(10);
									     TranslateTransition transition = new TranslateTransition();
									    // g.add(choice, 0, 0);
									     //g.setAlignment(Pos.CENTER);
									     choice.setAlignment(Pos.CENTER);
										//	root.setCenter(choice); 
									     g.add(choice,500, 15);
									     root.setCenter(g); 
									
								//	print(i,j,f,c,value,transition,g);
								//		
										
										ImageView back = new ImageView(
											"backk.png");
										back.setFitWidth(100);
										back.setFitHeight(80);
										Button backk = new Button("", back);
										backk.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												primaryStage.setScene(scene);

											}
											

										});
										ImageView start = new ImageView(
												"play.png");
											start.setFitWidth(100);
											start.setFitHeight(80);
											Button startt = new Button("", start);
											startt.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) {
													try {
														int k2=0;
													print(i,j,f,c,value,choice,k2);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

												}
												

											});
										
										HBox n = new HBox();
										n.getChildren().addAll(startt, backk);
										n.setSpacing(30);
										n.setAlignment(Pos.CENTER);
										n.setPadding(new Insets(25, 25, 50, 25));
										
										root.setAlignment(n, Pos.CENTER);
										root.setBottom(n);
										
										
										Scene scene = new Scene(root,1550,800);
										primaryStage.setScene(scene);
										primaryStage.show();
										
										
									}
									
								});
								table.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										BorderPane root = new BorderPane();
										GridPane g=new GridPane();
										root.setStyle("-fx-background-image:url('coo.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
										
									
										
									
										for(int i = 0 ; i < k ; i++)
										{ 
										   for(int j = 0 ; j< k ; j++)
										   {
											Label m=new Label(String.valueOf(d[i][j]))  ;
										
											m.setFont(Font.font(50));
											m.setFont(Font.font(null, FontWeight.BOLD, m.getFont().getSize()));
										  g.add(m, j, i);
										   }
										 
										}
									
										
										ImageView back = new ImageView(
												"backk.png");
										back.setFitWidth(100);
										back.setFitHeight(80);
										Button backk = new Button("", back);
										backk.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												primaryStage.setScene(scene);

											}
											

										});
										  g.setGridLinesVisible(true);
										 
										  
										  g.setHgap(10);
										  g.setVgap(10);
											
										root.setAlignment(backk, Pos.CENTER);
										root.setBottom(backk);
										g.setAlignment(Pos.CENTER);
									
										root.setCenter(g);
										Scene scene = new Scene(root,1550,800);
										primaryStage.setScene(scene);
										primaryStage.show();
										
									}
									
								});
								ImageView back = new ImageView(
										"backk.png");
								back.setFitWidth(100);
								back.setFitHeight(80);
								Button bk = new Button("", back);
								bk.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										primaryStage.setScene(scene);

									}
									

								});
								root.setAlignment(bk, Pos.CENTER);
								root.setBottom(bk);
								g.setAlignment(Pos.CENTER);
								root.setCenter(g);
								Scene scene = new Scene(root,1550,800);
								primaryStage.setScene(scene);
								primaryStage.show();
								
							}
							
						});
						
					}
				});
				
				root.setCenter(btn2);
			Scene scene = new Scene(root,1550,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	String player="";
	String player2="";

	public void print(int i,int j,int[][] f,int c,String [] value,  HBox choice,int k2) throws InterruptedException {
		
		if(i==j) {
			TranslateTransition t = new TranslateTransition();
			t.setDuration(Duration.seconds(2));
			t.setDelay(Duration.millis(k2 + 1500));
			k2 += 1500;
			t.setNode(choice.getChildren().get(i));
			t.setByY(50);
			t.play();
	      
	       
		}
		else if(f[i][j]==0) {
			
			
			if(c%2==0) {
				
				
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				if (c!= 0) {
					t.setDelay(Duration.millis(k2 + 1500));
					k2 += 1500;
				}
				t.setNode(choice.getChildren().get(j));

				t.setByY(-50);
				t.play();
				 System.out.print("player 1 takes "+value[j] +" ----");
				
	    	}
			else  {
				
				
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				t.setDelay(Duration.millis(k2 + 1500));
				k2 += 2000;
				t.setNode(choice.getChildren().get(j));
				t.setByY(50);
				t.play();
				
		       System.out.print("player 2 takes "+value[j] +" ----");
		       
		    	}
			
			print(i,j-1, f,--c,value,choice,k2);
		
	   	}
			
		else if(f[i][j]!=0) {
		
			if(c%2==0) {
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				if(c!=0) {
					t.setDelay(Duration.millis(k2 +1500));
					k2 += 1500;
					
				}
				t.setNode(choice.getChildren().get(i));

				t.setByY(-50);
				t.play();
				  System.out.print("player 1 takes "+value[i] +" ----");
	       
	   	
		}else {
			TranslateTransition t = new TranslateTransition();
			t.setDuration(Duration.seconds(2));
			t.setDelay(Duration.millis(k2 + 1500));
			k2 += 2000;
			
			t.setNode(choice.getChildren().get(i));
			t.setByY(50);
			t.play();
			  System.out.print("player 2 takes "+value[i] +" ----");
			
		}
			
			print(i+1,j, f,--c,value,choice,k2);
			
		}
		

	}
	/*public void print(int i,int j,int[][] f,int c,String [] value, TranslateTransition b,HBox g) throws InterruptedException {
	
		if(i==j) {
			 Duration duration = Duration.millis(k);
			System.out.print("player2 takes "+value[i] +" ----");
			b = new TranslateTransition(duration, g.getChildren().get(i));
			b.setByX(10);
	        b.setByY(250);
	       b.setCycleCount(1);
	       b.play();
	      
	       
		}
		else if(f[i][j]==0) {
			
			
			if(c%2==0) {
				 Duration duration = Duration.millis(k);
				b = new TranslateTransition(duration, g.getChildren().get(j));
				System.out.print("player1  takes "+value[j] +" ----");
			b.setByX(10);
	        b.setByY(100);
	        b.setCycleCount(1);
	        b.play();
	       
	    	}
			else  {
				 Duration duration = Duration.millis(k);
				b = new TranslateTransition(duration, g.getChildren().get(j));
				b.setByX(10);
		        b.setByY(250);
		       b.setCycleCount(1);
		       b.play();
		       System.out.print("player 2 takes "+value[j] +" ----");
		       
		    	}
			Thread.sleep(100);
			print(i,j-1, f,--c,value,b,g);
		
	   	}
			
		else if(f[i][j]!=0) {
		
			if(c%2==0) {
			 Duration duration = Duration.millis(k);
			b = new TranslateTransition(duration, g.getChildren().get(i));
			b.setByX(10);
	        b.setByY(100);
	        b.setCycleCount(1);
	       b.play();
	       System.out.print("player1  takes "+value[i] +" ----");
	       
	       
	   	
		}else {
			Duration duration = Duration.millis(k);
			b = new TranslateTransition(duration, g.getChildren().get(i));
			b.setByX(10);
	        b.setByY(250);
	        b.setCycleCount(1);
	      
		      
	       b.play();
	       System.out.print("player2  takes "+value[i] +" ----");
			
		}
			Thread.sleep(10);
			print(i+1,j, f,--c,value,b,g);
			
		}
		

	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}


/*int [] p1=new int[arr.length/2];
int [] p2=new int[arr.length/2];

int m=arr.length-1;
int v1=0;
int in=0;
int v2=0;
while(m>0 &&  v1<arr.length && m!=v1 && v2<user1.length) {
	
	if(user1[v2]==arr[v1]) {
		System.out.println("ji");
		p1[in]=0;
		v1++;
		v2++;
	}
	
	if(user1[v2]==arr[m]) {
		p1[in]=1;
		--m;
		v2++;
		}

	else {
     v1++;
     m--;
     }
	++in;

}


while(m>0 &&  v1<arr.length && m!=v1 && v2<user1.length) {
	
	if(user2[v2]==arr[v1]) {
		System.out.println("ji");
		p2[in]=0;
		v1++;
		v2++;
	}
	
	if(user2[v2]==arr[m]) {
		p2[in]=1;
		--m;
		v2++;
		}

	else {
     v1++;
     m--;
     }
	++in;

}


for(int ll=0;ll<user1.length;ll++) {
System.out.println(user1[ll]);
}
HBox choice=new HBox();
choice.setAlignment(Pos.CENTER);
choice.setSpacing(10);


for(int p=0;p<arr.length;p++) {

		Button b= new Button(arr[p] + "");
		b.setAlignment(Pos.CENTER);
		b.setShape(new Circle(150));
	   
	    b.setPrefSize(80,50);
	 	b.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		choice.getChildren().add(b);
}


        //c.setStroke(Color.PEACHPUFF);
   
        root5.add(choice, 0, 10);
        
       // root5.add(UserCh2, 0, 1);
        
       int x2 = 0;
		int y = arr.length - 1;
		for (int i2 = 0,j2=0, k2 = 0; i2 < arr.length / 2; i2++,j2++) {
			if (p1[i2] == 0) {
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				if (i2 != 0) {
					t.setDelay(Duration.millis(k2 + 1500));
					k2 += 1500;
				}
				t.setNode(choice.getChildren().get(x2++));

				t.setByY(-50);
				t.play();
			} else if (p1[i2] == 1) {
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				if(i2!=0) {
					t.setDelay(Duration.millis(k2 +1500));
					k2 += 1500;
					
				}
				t.setNode(choice.getChildren().get(y--));

				t.setByY(-50);
				t.play();
			}

			if (p2[j2] == 0) {
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				t.setDelay(Duration.millis(k2 + 1500));
				k2 += 2000;
				t.setNode(choice.getChildren().get(x2++));
				t.setByY(50);
				t.play();
			} else if (p2[j2] == 1) {
				TranslateTransition t = new TranslateTransition();
				t.setDuration(Duration.seconds(2));
				t.setDelay(Duration.millis(k2 + 1500));
				k2 += 1500;
				t.setNode(choice.getChildren().get(y--));
				t.setByY(50);
				t.play();
			}

		}

*/























