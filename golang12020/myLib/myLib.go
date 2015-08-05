// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package myLib

import (
	"fmt"
	"time"
)

type Events interface {
	OnTrigger()
}

type Timer struct {
	listeners []Events
}

func (t *Timer) AddListener(listener Events) {
	fmt.Println("Added an event")
	t.listeners = append(t.listeners, listener)
}

func (t *Timer) Start() {
	go func() {
		fmt.Println("time sleep")
		time.Sleep(5 * time.Second)
		t.onTrigger()
		fmt.Println("triggered")
	}()
}

func (t *Timer) onTrigger() {
	for _, i := range t.listeners {
		i.OnTrigger()
	}
}

func NewTimer() *Timer {
	return &Timer{listeners: make([]Events, 0)}
}
