/*
 * Copyright (c) 2011-2014, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{scene => jfxs}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.layout.Pane

/**
 * Object companion for [[scalafx.scene.control.DialogPane]].
 */
object DialogPane {
  /**
   * Converts a ScalaFX DialogPane to its JavaFX counterpart.
   *
   * @param v ScalaFX DialogPane
   * @return JavaFX DialogPane
   */
  implicit def sfxDialogPane2jfx(v: DialogPane): jfxsc.DialogPane =
    if (v != null) v.delegate else null
}

/**
 * DialogPane should be considered to be the root node displayed within a Dialog instance.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define TC DialogPane
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/DialogPane.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class DialogPane(override val delegate: jfxsc.DialogPane = new jfxsc.DialogPane())
  extends Pane(delegate)
  with SFXDelegate[jfxsc.DialogPane] {

  /**
   * The dialog graphic, presented either in the header, if one is showing, or
   * to the left of the [[scalafx.scene.control.DialogPane.content]].
   *
   * @return An ObjectProperty wrapping the current graphic.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty
  def graphic_=(value: Node): Unit = {
    ObjectProperty.fillProperty[jfxs.Node](this.graphic, value)
  }

  /**
   * Property representing the header area of the dialog pane. Note that if this
   * header is set to a non-null value, that it will take up the entire top
   * area of the DialogPane. It will also result in the DialogPane switching its
   * layout to the 'header' layout - as outlined in the [[scalafx.scene.control.DialogPane]] class
   * javadoc.
   */
  def header: ObjectProperty[jfxs.Node] = delegate.headerProperty
  def header_=(value: Node): Unit = {
    ObjectProperty.fillProperty[jfxs.Node](this.header, value)
  }

  /**
   * A property representing the header text for the dialog pane. The header text
   * is lower precedence than the [[scalafx.scene.control.DialogPane.header]] node, meaning
   * that if both the header node and the headerText properties are set, the
   * header text will not be displayed in a default DialogPane instance.
   *
   * <p>When headerText is set to a non-null value, this will result in the
   * DialogPane switching its layout to the 'header' layout - as outlined in
   * the [[scalafx.scene.control.DialogPane]] class javadoc.</p>
   */
  def headerText: StringProperty = delegate.headerTextProperty
  def headerText_=(value: String): Unit = {
    headerText() = value
  }

  def contentNode: ObjectProperty[jfxs.Node] = delegate.contentProperty
  def contentNode_=(value: Node): Unit = {
    ObjectProperty.fillProperty[jfxs.Node](this.contentNode, value)
  }

  def contentText: StringProperty = delegate.contentTextProperty
  def contentText_=(value: String): Unit = {
    contentText() = value
  }

  def expandableContent: ObjectProperty[jfxs.Node] = delegate.expandableContentProperty
  def expandableContent_=(value: Node): Unit = {
    ObjectProperty.fillProperty[jfxs.Node](this.expandableContent, value)
  }

  def expanded: BooleanProperty = delegate.expandedProperty
  def expanded_=(v: Boolean) {
    expanded() = v
  }

  /**
   * Observable list of button types used for the dialog button bar area
   * (created via the [[scalafx.scene.control.DialogPane.createButtonBar( )]] method). Modifying the contents
   * of this list will immediately change the buttons displayed to the user
   * within the dialog pane.
   *
   * @return The { @link ObservableList} of { @link ButtonType button types}
   *         available to the user.
   */
  def buttonTypes: ObservableBuffer[jfxsc.ButtonType] = delegate.getButtonTypes

  /**
   * This method provides a way in which developers may retrieve the actual
   * Node for a given [[scalafx.scene.control.ButtonType]]\ (assuming it is part of the
   * [[scalafx.scene.control.DialogPane.buttonTypes]] list).
   *
   * @param buttonType The { @link ButtonType} for which a Node representation is requested.
   * @return The Node used to represent the button type, as created by
   *         { @link #createButton(ButtonType)}, and only if the button type
   *         is part of the { @link #getButtonTypes() button types} list, otherwise null.
   */
  def lookupButton(buttonType: ButtonType): Node = delegate.lookupButton(buttonType)
}