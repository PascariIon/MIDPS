
#include <QtWidgets>

#include <math.h>

#include "button.h"
#include "calculator.h"


Calculator::Calculator(QWidget *parent)
    : QWidget(parent)
{
    sumInMemory = 0.0;
    sumAccumulated = 0.0;
    factorAccumulated = 0.0;
    waitingForOperand = true;
    display = new QLineEdit("0");
    display->setReadOnly(true);
    display->setAlignment(Qt::AlignRight);
    display->setMaxLength(15);

    QFont font = display->font();
    font.setPointSize(font.pointSize() + 8);
    display->setFont(font);


    for (int i = 0; i < NumDigitButtons; ++i) {
        digitButtons[i] = createButton(QString::number(i), SLOT(digitClicked()));

    }

    Button *pointButton = createButton(tr("."), SLOT(pointClicked()));
    Button *changeSignButton = createButton(tr("\302\261"), SLOT(changeSignClicked()));

    Button *backspaceButton = createButton(tr("\342\206\220"), SLOT(backspaceClicked()));
    QFont buttonFont = backspaceButton->font();
    buttonFont.setPointSize(buttonFont.pointSize() + 6);
    backspaceButton->setFont(buttonFont);
    Button *clearButton = createButton(tr("Clear"), SLOT(clear()));
    Button *clearAllButton = createButton(tr("Clear All"), SLOT(clearAll()));

    Button *clearMemoryButton = createButton(tr("MC"), SLOT(clearMemory()));
    Button *readMemoryButton = createButton(tr("MR"), SLOT(readMemory()));
    Button *setMemoryButton = createButton(tr("MS"), SLOT(setMemory()));
    Button *addToMemoryButton = createButton(tr("M+"), SLOT(addToMemory()));

    Button *divisionButton = createButton(tr("\303\267"), SLOT(multiplicativeOperatorClicked()));
    Button *timesButton = createButton(tr("\303\227"), SLOT(multiplicativeOperatorClicked()));
    Button *minusButton = createButton(tr("-"), SLOT(additiveOperatorClicked()));
    Button *plusButton = createButton(tr("+"), SLOT(additiveOperatorClicked()));

    Button *squareRootButton = createButton(tr("\342\210\232"), SLOT(unaryOperatorClicked()));
    Button *powerButton = createButton(tr("x\302\262"), SLOT(unaryOperatorClicked()));
    Button *cubeButton = createButton(tr("x\302\263"), SLOT(unaryOperatorClicked()));
    Button *reciprocalButton = createButton(tr("1/x"), SLOT(unaryOperatorClicked()));
    Button *equalButton = createButton(tr("="), SLOT(equalClicked()));

    Button *sinButton = createButton(tr("sin"), SLOT(unaryOperatorClicked()));
    Button *cosButton = createButton(tr("cos"), SLOT(unaryOperatorClicked()));
    Button *tanButton = createButton(tr("tan"), SLOT(unaryOperatorClicked()));
    Button *atanButton = createButton(tr("atan"), SLOT(unaryOperatorClicked()));

    Button *constantEButton = createButton(tr("\342\204\257"), SLOT(constantClicked()));
    Button *constantPIButton = createButton(tr("\341\264\250"), SLOT(constantClicked()));

    QGridLayout *mainLayout = new QGridLayout;

    mainLayout->setSizeConstraint(QLayout::SetFixedSize);
    mainLayout->addWidget(display, 0, 0, 1, 8);
    mainLayout->addWidget(backspaceButton, 1, 0, 1, 3);
    mainLayout->addWidget(clearButton, 1, 3, 1, 3);
    mainLayout->addWidget(clearAllButton, 1, 6, 1, 2);

    mainLayout->addWidget(clearMemoryButton, 2, 0);
    mainLayout->addWidget(readMemoryButton, 3, 0);
    mainLayout->addWidget(setMemoryButton, 4, 0);
    mainLayout->addWidget(addToMemoryButton, 5, 0);

    mainLayout->addWidget(sinButton, 2, 1);
    mainLayout->addWidget(cosButton, 3, 1);
    mainLayout->addWidget(tanButton, 4, 1);
    mainLayout->addWidget(atanButton, 5, 1);

    mainLayout->addWidget(constantEButton, 2, 7);
    mainLayout->addWidget(constantPIButton, 3, 7);


    for (int i = 1; i < NumDigitButtons; ++i) {
        int row = ((9 - i) / 3) + 2;
        int column = ((i - 1) % 3) + 1;
        mainLayout->addWidget(digitButtons[i], row, column + 1);
    }

    mainLayout->addWidget(digitButtons[0], 5, 2);
    mainLayout->addWidget(pointButton, 5, 3);
    mainLayout->addWidget(changeSignButton, 5, 4);

    mainLayout->addWidget(divisionButton, 2, 6);
    mainLayout->addWidget(timesButton, 3, 6);
    mainLayout->addWidget(minusButton, 4, 6);
    mainLayout->addWidget(plusButton, 5, 6);

    mainLayout->addWidget(squareRootButton, 2, 5);
    mainLayout->addWidget(powerButton, 3, 5);
    mainLayout->addWidget(cubeButton, 4, 5);
    mainLayout->addWidget(reciprocalButton, 5, 5);
    mainLayout->addWidget(equalButton, 4, 7, 2, 1);
    setLayout(mainLayout);

    setWindowTitle(tr("Calculator"));
}


void Calculator::constantClicked(){

    Button *clickedButton = qobject_cast<Button *>(sender());
    double constantValue = 0;
    if(clickedButton->text() == tr("\342\204\257"))
        constantValue = 2.7182818284;
    else if(clickedButton->text() == tr("\341\264\250"))
        constantValue = 3.1415926535;
    if(waitingForOperand) {
        display->clear();
        waitingForOperand = false;
    }

     display->setText(QString::number(constantValue));
}


void Calculator::digitClicked()
{
    Button *clickedButton = qobject_cast<Button *>(sender());
    int digitValue = clickedButton->text().toInt();
    if (display->text() == "0" && digitValue == 0.0)
        return;

    if (waitingForOperand) {
        display->clear();
        waitingForOperand = false;
    }
    display->setText(display->text() + QString::number(digitValue));
}


void Calculator::unaryOperatorClicked()

{
    Button *clickedButton = qobject_cast<Button *>(sender());
    QString clickedOperator = clickedButton->text();
    double operand = display->text().toDouble();
    double result = 0.0;

    if (clickedOperator == tr("\342\210\232")) {
        if (operand < 0.0) {
            rootFromNegative();
            return;
        }
        result = sqrt(operand);
    } else if (clickedOperator == tr("x\302\262"))
        result = pow(operand, 2.0);
      else if (clickedOperator == tr("x\302\263"))
        result = pow(operand, 3.0);
      else if(clickedOperator == tr("sin"))
        result = sin(operand);
    else if(clickedOperator == tr("cos"))
      result = cos(operand);
    else if(clickedOperator == tr("tan"))
      result = tan(operand);
    else if(clickedOperator == tr("atan"))
      result = atan(operand);
     else if (clickedOperator == tr("1/x")) {
        if (operand == 0.0) {
            divisionByZero();
            return;
        }
        result = 1.0 / operand;
    }
    display->setText(QString::number(result));
    waitingForOperand = true;
}

void Calculator::additiveOperatorClicked()
{
    Button *clickedButton = qobject_cast<Button *>(sender());
    QString clickedOperator = clickedButton->text();
    double operand = display->text().toDouble();
    if(operand == sumAccumulated)
        operand = 0;

    if (!pendingMultiplicativeOperator.isEmpty()) {

        if (!calculate(operand, pendingMultiplicativeOperator)) {
            divisionByZero();
            return;
        }
        display->setText(QString::number(factorAccumulated));
        operand = factorAccumulated;
        factorAccumulated = 0.0;
        pendingMultiplicativeOperator.clear();
    }


    if (!pendingAdditiveOperator.isEmpty()) {

        if (!calculate(operand, pendingAdditiveOperator)) {
            divisionByZero();
            return;
        }
        display->setText(QString::number(sumAccumulated));
    } else {
        sumAccumulated = operand;
    }


    pendingAdditiveOperator = clickedOperator;

    waitingForOperand = true;
}



void Calculator::multiplicativeOperatorClicked()
{
    Button *clickedButton = qobject_cast<Button *>(sender());
    QString clickedOperator = clickedButton->text();
    double operand = display->text().toDouble();
    if(operand == factorAccumulated)
        operand = 1;

    if (!pendingMultiplicativeOperator.isEmpty()) {
        if (!calculate(operand, pendingMultiplicativeOperator)) {
            divisionByZero();
            return;
        }
        display->setText(QString::number(factorAccumulated));
    } else {
        factorAccumulated = operand;
    }

    pendingMultiplicativeOperator = clickedOperator;
    waitingForOperand = true;
}


void Calculator::equalClicked()
{

    double operand = display->text().toDouble();


    if (!pendingMultiplicativeOperator.isEmpty()) {
        if (!calculate(operand, pendingMultiplicativeOperator)) {
            divisionByZero();
            return;
        }
        operand = factorAccumulated;
        factorAccumulated = 0.0;
        pendingMultiplicativeOperator.clear();
    }
    if (!pendingAdditiveOperator.isEmpty()) {
        if (!calculate(operand, pendingAdditiveOperator)) {
            divisionByZero();
            return;
        }
        pendingAdditiveOperator.clear();
    } else {
        sumAccumulated = operand;
    }

    display->setText(QString::number(sumAccumulated));
    sumAccumulated = 0.0;
    waitingForOperand = true;
}


void Calculator::pointClicked()
{
    if (waitingForOperand)
        display->setText("0");
    if (!display->text().contains("."))
        display->setText(display->text() + tr("."));
    waitingForOperand = false;
}


void Calculator::changeSignClicked()
{
    QString text = display->text();
    double value = text.toDouble();

    if (value > 0.0) {
        text.prepend(tr("-"));
    } else if (value < 0.0) {
        text.remove(0, 1);
    }
    display->setText(text);
}


void Calculator::backspaceClicked()
{
    if (waitingForOperand)
        return;

    QString text = display->text();
    text.chop(1);
    if (text.isEmpty()) {
        text = "0";
        waitingForOperand = true;
    }
    display->setText(text);
}


void Calculator::clear()
{
    if (waitingForOperand)
        return;

    display->setText("0");
    waitingForOperand = true;
}


void Calculator::clearAll()
{
    sumAccumulated = 0.0;
    factorAccumulated = 0.0;
    pendingAdditiveOperator.clear();
    pendingMultiplicativeOperator.clear();
    display->setText("0");
    waitingForOperand = true;
}


void Calculator::clearMemory()
{
    sumInMemory = 0.0;
}

void Calculator::readMemory()
{
    display->setText(QString::number(sumInMemory));
    waitingForOperand = true;
}

void Calculator::setMemory()
{
    equalClicked();
    sumInMemory = display->text().toDouble();
}

void Calculator::addToMemory()
{
    equalClicked();
    sumInMemory += display->text().toDouble();
}


Button *Calculator::createButton(const QString &text, const char *member)
{
    Button *button = new Button(text);
    connect(button, SIGNAL(clicked()), this, member);
    return button;
}


void Calculator::divisionByZero()
{
    clearAll();
    display->setText(tr("Division by 0!"));
}


void Calculator::rootFromNegative()
{
    clearAll();
    display->setText(tr("Invalid input!"));
}


bool Calculator::calculate(double rightOperand, const QString &pendingOperator)
{
    if (pendingOperator == tr("+")) {
        sumAccumulated += rightOperand;
    } else if (pendingOperator == tr("-")) {
        sumAccumulated -= rightOperand;
    } else if (pendingOperator == tr("\303\227")) {
        factorAccumulated *= rightOperand;
    } else if (pendingOperator == tr("\303\267")) {
        if (rightOperand == 0.0)
            return false;
        factorAccumulated /= rightOperand;
    }
    return true;
}

