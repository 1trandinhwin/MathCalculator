import processing.core.PApplet;

/**
 * @author Winnie Trandinh
 * Last Modified: February 26, 2017
 * 
 	*Critcical Requirements (Program must have all of these requirements ____/6
	*Selection menu using if/else if/else to handle the user selection		yes
	*Program calculates the sin, cos, tan									yes
	*Program calculates the asin, acos, atan angles for two sides			yes
	*Error handles the input from the user									yes
	*Appropriate commenting and Program header								yes
	*Program works without bugs												yes
	
	
	Optional Requirements (Any Combinations to get 4 marks) __/4
	*Extended user interaction(Contextualized interactions)					yes
	* 2 Simple Additional functions (Solve for point of intersections)		no
	** 1 complicated Additional Function									yes (intersects and roots)
	***Magical items of an impressive quality  								maybe?
 *
 *
 *
 *
 * The program calculates the trig ratios, calculates the angle in degrees, and calculates the side length of a right angle triangle.
 * It also solves for points of intersection between two linear equations, and finds the roots of a quadratic.
 *
 *
 *
 */
public class FinalCalculator extends PApplet{

	/**
	 * @param args
	 */
		
	String gameState = "title";		//game state
	
	char [] letters = new char [0];	//string of inputs from keyboard
	
	double inputData [] = new double [4];	//number form of inputs
	
	boolean errorMessage = false;			//trig error message
	boolean errorMessage2 = false; 			//systems error message
	
	//called in title screen
	public void title () {
		background(200, 200, 200);					//creates background (grey)
		fill(0, 0, 200);							//creates text colour (blue)
		textSize(50);								//sets text size
		text("Master Calculator", 45, 245);
		textSize(20);
		text("Click anywhere to begin", 133, 400);
	}
	
	//called during first selection screen
	public void generalSelection() {
		background(200, 200, 200);
		fill(200, 0, 0);	//red
		textSize(50);
		text("Select a category", 55, 100);
		textSize(40);
		fill(0, 0, 200); //blue
		//draws rects over text
		rect(115, 200, 285, 75);
		rect(110, 350, 290, 80);
		
		fill(255, 255, 255);	//white
		text("Trigonometry", 125, 250);
		text("Solve Systems", 120, 400);
	}

	//selection screen in trig section
	public void trigSelection() {
		background(200, 200, 200);
		fill(200, 0, 0);	//red
		textSize(30);
		text("Select one of the following:", 55, 80);
		
		fill(0, 0, 200);	//blue
		//draws rects over text
		rect(210, 145, 88, 55);
		rect(185, 270, 140, 50);
		rect(180, 395, 170, 55);
		
		fill(255, 255, 255);	//white
		textSize(40);
		text("Sine", 215, 185);
		text("Cosine", 190, 310);
		text("Tangent", 185, 435);
	}
	
	//called during the second selection screen of trig
	public void trigSelection2() {
		background(200, 200, 200);
		fill(200, 0, 0);
		textSize(30);
		text("Calculate the:", 145, 70);
		
		fill(0, 0, 200);
		rect(210, 150, 85, 50);
		rect(210, 275, 95, 50);
		rect(170, 400, 185, 50);
		
		fill(255, 255, 255);
		text("ratio", 220, 185);
		text("angle", 220, 310);
		text("side length", 180, 435);
		
		//shortens the letters array to hold no data
		while (letters.length != 0) {
			letters = shorten(letters);
		}
	}

	//this calculates all the trig related calculations
	public void trigCalculations() {
		background(200, 200, 200);
		fill(0, 0, 200);
		textSize(20);
		
		//if it contains "3", it is in the final calculation stage, and calculates the result
		if (gameState.contains("3") ) {
			if (gameState.contains("sin") ) {									//sin calculations
				if (gameState.contains("Ratio") ) {
					double answer = Math.sin(inputData[0] / inputData[1]);		//calculates sin ratio
					answer = Math.rint(answer * 100) / 100;						//rounds the ratio to two decimals
					text("The sine ratio is " + answer, 50, 200);				//presents the ratio
					
				} else if (gameState.contains("Angle") ) {
					double answer = Math.toDegrees (Math.asin(inputData[0] / inputData[1]) );	//calculates angle in degrees
					answer = Math.rint(answer * 100) / 100;										//rounds to two decimals
					if (Double.isNaN(answer) ) {												//if hyp is larger than opp, triangle is not possible
						text("The triangle cannot be made", 50, 200);
					} else {
						text("The angle in degrees is " + answer, 50, 200);						//presents the angle
					}
					
				} else if (gameState.contains("Length") ) {
					double answer = Math.sin(Math.toRadians(inputData[0]) )  * inputData[1];	//calculates the side length
					answer = Math.rint(answer * 100) / 100;										//rounds to two decimals
					text("The opposite side is " + answer + " units long", 50, 200);			//presents the length
					
				}
				
			} else if (gameState.contains("cos") ) {							//cos calculations
				if (gameState.contains("Ratio") ) {								//see sin calculations for explanations
					double answer = Math.cos(inputData[0] / inputData[1]);
					answer = Math.rint(answer * 100) / 100;
					text("The cosine ratio is " + answer, 50, 200);
					
				} else if (gameState.contains("Angle") ) {
					double answer = Math.toDegrees (Math.acos(inputData[0] / inputData[1]) );
					answer = Math.rint(answer * 100) / 100;
					if (Double.isNaN(answer) ) {
						text("The triangle cannot be made", 50, 200);
					} else {
						text("The angle in degrees is " + answer, 50, 200);
					}
					
				} else if (gameState.contains("Length") ) {
					double answer = Math.cos(Math.toRadians(inputData[0]) )  * inputData[1];
					answer = Math.rint(answer * 100) / 100;
					text("The adjacent side is " + answer + " units long", 50, 200);
				}
				
			} else if (gameState.contains("tan") ) {							//tan calculations
				if (gameState.contains("Ratio") ) {								//see sin calculations for explanations
					double answer = Math.tan(inputData[0] / inputData[1]);
					answer = Math.rint(answer * 100) / 100;
					text("The tangent ratio is " + answer, 50, 200);
					
				} else if (gameState.contains("Angle") ) {
					double answer = Math.toDegrees (Math.atan(inputData[0] / inputData[1]) );
					answer = Math.rint(answer * 100) / 100;
					text("The angle in degrees is " + answer, 50, 200);
					
				} else if (gameState.contains("Length") ) {
					double answer = Math.tan(Math.toRadians(inputData[0]) )  * inputData[1];
					answer = Math.rint(answer * 100) / 100;
					text("The opposite side is " + answer + " units long", 50, 200);
				}
			}
			
			text("click anywhere to proceed to menu", 100, 400);
			
		} else { 			//if does not contain "3"
			if (letters.length == 0) {			//if array is blank
				
				//ratio or angle calculations
				if (gameState.contains("sinRatio") || gameState.contains("sinAngle") ) {		//sin calculations
					if (gameState.contains("1") ) {
						text("type in opposite sidelength", 85, 115);		//gives directions to user
					} else if (gameState.contains("2") ) {
						text("type in hypotenuse sidelength", 85, 115);
					}
				} else if (gameState.contains("cosRatio") || gameState.contains("cosAngle") ) {		//cos calculations
					if (gameState.contains("1") ) {
						text("type in adjacent sidelength", 85, 115);
					} else if (gameState.contains("2") ) {
						text("type in hypotenuse sidelength", 85, 115);
					}
				} else if (gameState.contains("tanRatio") || gameState.contains("tanAngle") ) {		//tan calculations
					if (gameState.contains("1") ) {
						text("type in opposite sidelength", 85, 115);
					} else if (gameState.contains("2") ) {
						text("type in adjacent sidelength", 85, 115);
					}
					
				//length calculations
				} else if (gameState.contains("sinLength") ) {		//sin calculations
					if (gameState.contains("1") ) {
						text("type in angle theta", 85, 115);		//gives directions to user
					} else if (gameState.contains("2") ) {
						text("type in hypotenuse sidelength", 85, 115);
					}
				} else if (gameState.contains("cosLength") ) {		//cos calculations
					if (gameState.contains("1") ) {
						text("type in angle theta", 85, 115);
					} else if (gameState.contains("2") ) {
						text("type in hypotenuse sidelength", 85, 115);
					}
				} else if (gameState.contains("tanLength") ) {		//tan calculations
					if (gameState.contains("1") ) {
						text("type in angle theta", 85, 115);
					} else if (gameState.contains("2") ) {
						text("type in adjacent sidelength", 85, 115);
					}
				}
					
					
			} else {		//if array is not empty
				//displays the array of keys inputed by user
				for (int i = 0; i < letters.length; i++) {
					text(letters[i], 100 + i*20,200);
				}
				text("Press enter to continue", 140, 350);
				
				//ratio or angle calculation
				if (gameState.contains("sinRatio")  || gameState.contains("sinAngle")) {			//sin calculations
					if (gameState.contains("1") ) {
						text("opposite = ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("hypotenuse = ", 150, 115);
					}
				} else if (gameState.contains("cosRatio") || gameState.contains("cosAngle") ) {		//cos calculations
					if (gameState.contains("1") ) {
						text("adjacent = ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("hypotenuse = ", 150, 115);
					}
				} else if (gameState.contains("tanRatio") || gameState.contains("tanAngle") ) {		//tan calculations
					if (gameState.contains("1") ) {
						text("opposite = ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("adjacent = ", 150, 115);
					}
					
				//length calculation
				} else if (gameState.contains("sinLength") ) {		//sin calculations
					if (gameState.contains("1") ) {
						text("theta = ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("hypotenuse = ", 150, 115);
					}
				} else if (gameState.contains("cosLength") ) {		//cos calculations
					if (gameState.contains("1") ) {
						text("theta = ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("hypotenuse = ", 150, 115);
					}
				} else if (gameState.contains("tanLength") ) {		//tan calculations
					if (gameState.contains("1") ) {
						text("theta = ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("adjacent = ", 150, 115);
					}
				}

			}
			
		}
		
	}
	
	//selection screen for solving systems
	public void solvingSelection() {
		background(200, 200, 200);
		fill(200, 0, 0);
		textSize(30);
		text("Select one of the following:", 55, 80);
		
		fill(0, 0, 200);
		rect(210, 145, 130, 50);
		rect(185, 270, 200, 50);
		
		fill(255, 255, 255);
		textSize(40);
		text("Linear", 215, 185);
		text("Quadratic", 190, 310);
	}
	
	
	//this does all the calculations related to solving systems
	public void systemsCalculations() {
		background(200, 200, 200);
		fill(0, 0, 200);
		textSize(20);
		
		if (gameState.contains("3") ) {								//does final calculations
			if (gameState.contains("linear") ) {					//if calculating linear intercepts
				double answerX = (inputData[3] - inputData[1]) / (inputData[0] - inputData[2]);		//calculates x value
				double answerY = inputData[0] * answerX + inputData[1];								//calculates y value
				
				answerX = Math.rint(answerX * 100) / 100;			//rounds to 2 decimals
				answerY = Math.rint(answerY * 100) / 100;			//rounds to 2 decimals
				
				if (Double.isNaN(answerX) ) {						//parallel lines on top of each other
					text("There are infinite points of intersection", 50, 200);
				} else if (Double.isInfinite(answerX) ) {			//parallel lines not on top of each other
					text("There are no points of intersection", 50, 200);
				} else {
					text("The point of intersection is (" + answerX + ", " + answerY + ")", 50, 200); 	//displays point of intersection
				}
			
			} else if (gameState.contains("quadratic") ) {			//if calculating roots
				double discriminant = Math.sqrt(Math.pow(inputData[1], 2) - 4 * inputData[0] * inputData[2]);	//calculates discriminant
				double answerX1 = (-1 * inputData[1] + discriminant) / (2 * inputData[0]);					//calculates first possibility
				
				double answerX2 = (-1 * inputData[1] - discriminant) / (2 * inputData[0]);					//calculates second possibility
				
				//rounds roots to two decimals
				answerX1 = Math.rint(answerX1 * 100) / 100;
				answerX2 = Math.rint(answerX2 * 100) / 100;
				
				if (Double.isNaN(answerX1) && Double.isNaN(answerX2) ) {	//no roots
					text("There are no roots", 50, 200);
				} else if (Double.isNaN(answerX1) ) {						//one root
					text("The root is " + answerX2, 50, 200);
				} else if (Double.isNaN(answerX2) ) {
					text("The root is " + answerX1, 50, 200);				//one root
				} else {
					text("The roots are " + answerX1 + " and " + answerX2, 50, 200);	//two roots
				}
				
			}
				
			text("click anywhere to proceed to menu", 100, 400);
			
		} else {
			
			if (letters.length == 0) {						//if empty array
				if (gameState.contains("linear") ) {
					if (gameState.contains("1") ) {
						text("type in first equation in the form of y=mx+b", 45, 115);		//prompts user input
					} else if (gameState.contains("2") ) {
						text("type in second equation in the form of y=mx+b", 25, 115);
					}
				} else if (gameState.contains("quadratic") ) {
					if (gameState.contains("1") ) {
						text("type in equation in the form of y=ax^2+bx+c", 15, 115);
					}
				}
			
			} else {		//if array not empty
				for (int i = 0; i < letters.length; i++) {		//displays array on screen
					text(letters[i], 100 + i*20,200);
				}
				text("Press enter to continue", 140, 350);
				
				if (gameState.contains("linear") ) {
					if (gameState.contains("1") ) {
						text("equation 1: ", 150, 115);
					} else if (gameState.contains("2") ) {
						text("equation 2: ", 150, 115);
					}
				}
			}
			
		}
		
	}
	
	
	
	
	
	//this is called whenever a key is typed
	public void keyTyped() {
		
		if ( key == DELETE || key == BACKSPACE) {		//deletes most recent index
			if (letters.length != 0) {
				letters = shorten(letters);
			}
		} else if (key == ENTER) {						//enter key is typed
			if (gameState.contains("Ratio1") || gameState.contains("Angle1") || gameState.contains("Length1") ) {
				String letterS = new String (letters);			//turns char array into a string
				try {
					inputData[0] = Double.parseDouble(letterS);			//try to turn string into double
					errorMessage = false;								//disables error message
					
					//advances screen
					//ratio calculation
					if (gameState.equals("sinRatio1") ) {
							gameState = "sinRatio2";
					} else if (gameState.equals("cosRatio1") ) {
						gameState = "cosRatio2";
					} else if (gameState.equals("tanRatio1") ) {
						gameState = "tanRatio2";
					//angle calculation
					} else if (gameState.equals("sinAngle1") ) {
						gameState = "sinAngle2";
					} else if (gameState.equals("cosAngle1") ) {
						gameState = "cosAngle2";
					} else if (gameState.equals("tanAngle1") ) {
						gameState = "tanAngle2";
					//length calculation
					} else if (gameState.equals("sinLength1") ) {
						gameState = "sinLength2";
					} else if (gameState.equals("cosLength1") ) {
						gameState = "cosLength2";
					} else if (gameState.equals("tanLength1") ) {
						gameState = "tanLength2";
					}
					
					//empties array once done
					while (letters.length != 0) {
						letters = shorten(letters);
					}
					
				}
				catch (NumberFormatException e) {	//if could not turn into double, return error
					errorMessage = true;			//displays error message
				}

			} else if (gameState.contains("Ratio2") || gameState.contains("Angle2") || gameState.contains("Length2") ) {
				//see above for explanations
				String letterS = new String (letters);
				try {
					inputData[1] = Double.parseDouble(letterS);
					errorMessage = false;
					
					if (gameState.equals("sinRatio2") ) {
						gameState = "sinRatio3";
					} else if (gameState.equals("cosRatio2") ) {
						gameState = "cosRatio3";
					} else if (gameState.equals("tanRatio2") ) {
						gameState = "tanRatio3";
						
					} else if (gameState.equals("sinAngle2") ) {
						gameState = "sinAngle3";
					} else if (gameState.equals("cosAngle2") ) {
						gameState = "cosAngle3";
					} else if (gameState.equals("tanAngle2") ) {
						gameState = "tanAngle3";
						
					} else if (gameState.equals("sinLength2") ) {
						gameState = "sinLength3";
					} else if (gameState.equals("cosLength2") ) {
						gameState = "cosLength3";
					} else if (gameState.equals("tanLength2") ) {
						gameState = "tanLength3";
					}
					
					while (letters.length != 0) {
						letters = shorten(letters);
					}
				}
				catch (NumberFormatException e) {
					errorMessage = true;
				}
				
			//linear intercepts
			} else if (gameState.contains("linear") ) {
				String letterS = new String (letters);				//converts char array into string
				String [] equation = split(letterS, '=');			//splits string creating y and mx+b
				String equation2 = null;							//initializes variable
				try {
					equation2 = equation[1];						//stores array index into new string, stores mx+b
					String [] values = split(equation2, 'x');		//splits again to create m and b
					try {
						if (gameState.equals("linear1") ) {
							//converts string array into double array
							for (int i = 0; i < values.length; i ++) {
								inputData [i] = Double.parseDouble(values[i]);
							}
							errorMessage2 = false;
							gameState = "linear2";			//advances screen
							
							//empties array once done
							while (letters.length != 0) {
								letters = shorten(letters);
							}
						
						//see above for explanation
						} else if (gameState.equals("linear2") ) {
							for (int i = 0; i < values.length; i ++) {
								inputData [i+2] = Double.parseDouble(values[i]);
							}
							errorMessage2 = false;
							gameState = "linear3";
							
							while (letters.length != 0) {
								letters = shorten(letters);
							}
							
						}
					}		//if could not convert string into double
					catch (NumberFormatException e) {
						errorMessage2 = true;
					}
				}			//if missing " y= " part of equation
				catch (ArrayIndexOutOfBoundsException a) {
					errorMessage2 = true;
				}
				
			//quadratic roots
			} else if (gameState.contains("quadratic") ) {
				String letterS = new String (letters);				//stores char array into string
				String [] equation = split(letterS, '=');			//splits string into y and ax^2+bx+c
				String equation2 = null;							//initializes variables
				String equation4 = null;
				String equation6 = null;
				String equation8 = null;
				
				boolean negativeValue = false;						//later used if the b value is negative
				
				String [] values = new String [6];					//creates new string array
				try {
					equation2 = equation[1];						//stores ax^2+bx+c into new string
					String [] equation3 = split(equation2, '^');	//splits into ax and 2+bx+c
					try {
						equation4 = equation3[0];									//stores ax into new string
						String [] equation5 = split(equation4, 'x');				//splits into a and null
						values[0] = equation5 [0];									//stores a value into values array
						try {
							equation6 = equation3[1];								//stores 2+bx+c into new string
							String [] equation7 = split(equation6, 'x');			//splits into 2+b and +c
							try {
								equation8 = equation7[0];							//stores 2+b into new string
								if (equation8.contains("+") ) {						//if contains "+"
									String [] equation9 = split(equation8, '+');	//split on "+" creating 2 and b
									values[1] = equation9[1];						//stores b value into values array
									negativeValue = false;							//b value is positive so set this to false
								} else if (equation8.contains("-") ) {				//if contains "-"
									String [] equation9 = split(equation8, '-');	//split on "-" creating 2 and b
									values[1] = equation9[1];						//stores b value into values array
									negativeValue = true;							//b value is negative so set this to true
								}
							
								try {
									values[2] = equation7[1];						//stores c value into values array
								
									try {						
										//converts strings into doubles array
										for (int i = 0; i < 3; i ++) {
											inputData [i] = Double.parseDouble(values[i]);
										}
										//if b value was negative, then multiply by -1 to make it negative
										if (negativeValue == true) {
											inputData[1] = inputData[1] * - 1;
										}
										errorMessage2 = false;			//successful so disable error message
										gameState = "quadratic3";		//advance screen
										//clears array once done
										while (letters.length != 0) {
											letters = shorten(letters);
										}
										
										
										
									}
									catch (NumberFormatException e) {		//could not convert to doubles
										errorMessage2 = true;
									}
									
									
								} 
								catch (ArrayIndexOutOfBoundsException a) {	//incorrect format
									errorMessage2 = true;
								}
								
								
							}
							catch (ArrayIndexOutOfBoundsException a) {		//incorrect format
								errorMessage2 = true;
							}
										
						} 
						catch (ArrayIndexOutOfBoundsException a) {			//incorrect format
							errorMessage2 = true;
						}
										
					} 
					catch (ArrayIndexOutOfBoundsException a) {				//incorrect format
						errorMessage2 = true;
					}
				}
				catch (ArrayIndexOutOfBoundsException a) {					//incorrect format
					errorMessage2 = true;
				}
			}
			
		} else {	//normal keys add onto array once typed
			letters = append(letters, key);
		}
	}
	
	
	//called whenever mouse is pressed
	//does checks of mouse position to see if it is hovering over a button and if clicked on the button, advances the screen by changing the gameState accordingly
	public void mousePressed() {
		if (gameState.equals("title") ) {
			gameState = "generalSelection";
			
		} else if (gameState.equals("generalSelection") ) {
			if (mouseX >= 115 && mouseX <= 400 && mouseY >= 200 && mouseY <= 275) {			//trigonometry
				gameState = "trigSelection";
			} else if (mouseX >= 110 && mouseX <= 400 && mouseY >= 350 && mouseY <= 430) {	//solve systems
				gameState = "solvingSelection";
			}
		
		} else if (gameState.equals("trigSelection") ) {
			if (mouseX >= 210 && mouseX <= 298 && mouseY >= 145 && mouseY <= 200) {
				gameState = "sinSelection";
			} else if (mouseX >= 185 && mouseX <= 325 && mouseY >= 270 && mouseY <= 320) {
				gameState = "cosSelection";
			} else if (mouseX >= 180 && mouseX <= 350 && mouseY >= 395 && mouseY <= 450) {
				gameState = "tanSelection";
			}
			
		} else if (gameState.equals("sinSelection") ) {
			if (mouseX >= 210 && mouseX <= 295 && mouseY >= 150 && mouseY <= 200) {
				gameState = "sinRatio1";
			} else if (mouseX >= 210 && mouseX <= 305 && mouseY >= 275 && mouseY <= 325) {
				gameState = "sinAngle1";
			} else if (mouseX >= 170 && mouseX <= 355 && mouseY >= 400 && mouseY <= 450) {
				gameState = "sinLength1";
			}
			
		} else if (gameState.equals("cosSelection") ) {
			if (mouseX >= 210 && mouseX <= 295 && mouseY >= 150 && mouseY <= 200) {
				gameState = "cosRatio1";
			} else if (mouseX >= 210 && mouseX <= 305 && mouseY >= 275 && mouseY <= 325) {
				gameState = "cosAngle1";
			} else if (mouseX >= 170 && mouseX <= 355 && mouseY >= 400 && mouseY <= 450) {
				gameState = "cosLength1";
			}
			
		} else if (gameState.equals("tanSelection") ) {
			if (mouseX >= 210 && mouseX <= 295 && mouseY >= 150 && mouseY <= 200) {
				gameState = "tanRatio1";
			} else if (mouseX >= 210 && mouseX <= 305 && mouseY >= 275 && mouseY <= 325) {
				gameState = "tanAngle1";
			} else if (mouseX >= 170 && mouseX <= 355 && mouseY >= 400 && mouseY <= 450) {
				gameState = "tanLength1";
			}
			
		} else if (gameState.contains("3") ) {
			gameState = "generalSelection";
		
		} else if (gameState.equals("solvingSelection") ) {
			if (mouseX >= 210 && mouseX <= 340 && mouseY >= 145 && mouseY <= 195) {
				gameState = "linear1";
			} else if (mouseX >= 185 && mouseX <= 385 && mouseY >= 270 && mouseY <= 320) {
				gameState = "quadratic1";
			}
		}
		

	}
	
	public static void main(String[] args) {
		PApplet.main("FinalCalculator");	//allows for use of processing library
		
	}
	
	//called at start, creates the screen of 500 by 500 pixels
	public void settings() {
		size(500, 500);
	}

	//called periodically
	//calls different functions according to the gameState
	public void draw() {
		if (gameState.equals("title")) {
			title();
		} else if (gameState.equals("generalSelection")) {
			generalSelection();
		} else if (gameState.equals("trigSelection") ) {
			trigSelection();
		} else if (gameState.equals("sinSelection") || 
				gameState.equals("cosSelection") || 
				gameState.equals("tanSelection")) {
			trigSelection2();
		} else if (gameState.contains("sin") ||
				gameState.contains("cos") ||
				gameState.contains("tan") ) {
			trigCalculations();
		} else if (gameState.equals("solvingSelection") ) {
			solvingSelection();
		} else if (gameState.contains("linear") || gameState.contains("quadratic") ) {
			systemsCalculations();
		}
		
		//displays the error messages if set to true
		if (errorMessage == true) {
			text("Invalid length, it must be a number", 85, 310);
		} else if (errorMessage2 == true) {
			textSize(13);
			text("Invalid format, follow the format provided using decimals and no spaces", 25, 310);
			textSize(20);
		}

	}

}
